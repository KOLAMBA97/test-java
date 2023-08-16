package com.example.api.repo;

import com.example.api.entity.Fact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface FactRepo extends JpaRepository<Fact, Long> {

    @Query(value = "SELECT * FROM fact WHERE app_user_id = :user_id and data >= :date1 and data <= :date2", nativeQuery = true)
    List<Fact> findFacts(@Param("user_id") long user_id, @Param("date1") Date date1, @Param("date2") Date date2);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM fact WHERE app_user_id = :user_id and id = :id", nativeQuery = true)
    void delFact(@Param("user_id") long user_id, @Param("id") long id);
}
