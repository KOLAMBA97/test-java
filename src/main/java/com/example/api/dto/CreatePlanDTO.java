package com.example.api.dto;
import lombok.Data;

import java.util.Date;

@Data

public class CreatePlanDTO {
    private int user_id;
    private String category;
    private Date date;
    protected int sum;
}
