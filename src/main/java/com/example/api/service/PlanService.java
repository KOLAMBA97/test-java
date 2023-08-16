package com.example.api.service;

import com.example.api.entity.AppUser;
import com.example.api.entity.Plan;
import com.example.api.repo.AppUserRepo;
import com.example.api.repo.PlanRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlanService {

    @Autowired
    PlanRepo planRepo;

    @Autowired
    AppUserRepo appUserRepo;

    public Plan createPlan(long user_id, String category, int sum, Date date) {
        AppUser appUser = appUserRepo.getById(user_id);
        Plan plan = new Plan(appUser, category, sum, date);
        planRepo.save(plan);
        return plan;
    }


    public List<Plan> getPlanBetween(long user_id, Date data1, Date data2) {
        return planRepo.findPlan(user_id, data1, data2);
    }

    public void DeletePlanBetween(long user_id, Date data1, Date data2) {
        planRepo.deletePlan(user_id, data1, data2);
    }
}
