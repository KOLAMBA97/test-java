package com.example.api.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;



    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "plans")
    private AppUser appUser;

    private String category;
    private Date date;
    private int sum;


    public Plan() {
    }

    public Plan(AppUser appUser, String category, int sum, Date date) {
       this.appUser = appUser;
        this.category = category;
        this.sum = sum;
        this.date = date;
    }
}
