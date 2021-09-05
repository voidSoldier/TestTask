package com.javajunior.stockdataparser.repository;

import com.javajunior.stockdataparser.model.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface HistoryRepository extends JpaRepository<History, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM History h WHERE h.id=:id")
    int delete(@Param("id") int id);
}
