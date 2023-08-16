package com.example.api.dto;

import lombok.Data;

@Data
public class CreateFactDTO {
    private int user_id;
    private String category;
    protected int sum;
    private String comment;
}
