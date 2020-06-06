package com.javajunior.testtask.repository;


import com.javajunior.testtask.model.History;
import com.javajunior.testtask.model.Security;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public interface SecurityRepository extends JpaRepository<Security, Integer> {


    @Transactional
    @Modifying
    int deleteById(int id);

    @Query
    Security findSecurityBySecid(String secid);

//    @Query
//    Security findSecuritiesBySecid(String secid);

    // как быть с маппингом?
//    @Transactional
//    @Modifying
//    @Query ("UPDATE Security s SET s.history = :history WHERE s.id=:id")
//    void addHistory(int id, History history);

}
