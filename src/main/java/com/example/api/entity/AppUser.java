package com.example.api.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    public AppUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    private String username;
    private String password;

    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Fact> facts;

    @OneToMany(mappedBy = "appUser", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JsonIgnore
    private List<Plan> plans;

    public AppUser() {
    }


}
