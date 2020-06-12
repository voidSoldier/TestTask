package com.javajunior.testtask.repository;


import com.javajunior.testtask.model.Security;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional(readOnly = true)
public interface SecurityRepository extends JpaRepository<Security, Integer> {


    @Transactional
    @Modifying
    @Query("DELETE FROM Security s WHERE s.id=:id")
    int delete(@Param("id") int id);


    @Query
    Security findSecurityBySecid(String secid);


    @EntityGraph(attributePaths = {"histories"}, type = EntityGraph.EntityGraphType.LOAD)
    @Query("SELECT s FROM Security s JOIN FETCH s.histories h WHERE h.secid=s.secid")
    List<Security> getAllWithHistory();

}
