package com.example.api.repo;

import com.example.api.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

public interface PlanRepo extends JpaRepository<Plan, Long> {
    @Query(value = "SELECT * FROM plan WHERE app_user_id = :user_id and date >= :date1 and date <= :date2", nativeQuery = true)
    List<Plan> findPlan(@Param("user_id") long user_id, @Param("date1") Date date1, @Param("date2") Date date2);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM plan WHERE app_user_id = :user_id and date >= :date1 and date <= :date2", nativeQuery = true)
    void deletePlan(@Param("user_id") long user_id, @Param("date1") Date date1, @Param("date2") Date date2);
}
