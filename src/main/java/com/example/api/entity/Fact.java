package com.example.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Fact {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private Date data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnoreProperties(value = "facts")
    private AppUser appUser;

    private String category;
    private int sum;
    private String comment;

    public Fact() {
    }

    public Fact(AppUser appUser, String category, int sum, String comment) {
        this.appUser = appUser;
        this.category = category;
        this.sum = sum;
        this.comment = comment;
        this.data = new Date();
    }
}
