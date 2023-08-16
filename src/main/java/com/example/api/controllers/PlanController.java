package com.example.api.controllers;

import com.example.api.dto.CreatePlanDTO;
import com.example.api.entity.Plan;
import com.example.api.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class PlanController {
    @Autowired
    PlanService planService;

    @PostMapping("/add")
    public Plan createPlan(@RequestBody CreatePlanDTO createPlanDTO) {
        return planService.createPlan(createPlanDTO.getUser_id(), createPlanDTO.getCategory(), createPlanDTO.getSum(), createPlanDTO.getDate());
    }

    @GetMapping("/byDate")
    public List<Plan> getByDates(@RequestParam long user_id, @RequestParam String data1, @RequestParam String data2) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return planService.getPlanBetween(user_id, format.parse(data1), format.parse(data2));
    }

    @GetMapping("/delPlan")
    public void deleteByDates(@RequestParam long user_id, @RequestParam String data1, @RequestParam String data2) throws ParseException {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        planService.DeletePlanBetween(user_id, format.parse(data1), format.parse(data2));
    }
}
