package com.example.api.service;

import com.example.api.entity.AppUser;
import com.example.api.entity.Fact;
import com.example.api.repo.AppUserRepo;
import com.example.api.repo.FactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FactService {

    @Autowired
    FactRepo factRepo;

    @Autowired
    AppUserRepo appUserRepo;

    public Fact createFact(long user_id, String category, int sum, String comment) {
        AppUser appUser = appUserRepo.getById(user_id);
        Fact fact = new Fact(appUser, category, sum, comment);
        factRepo.save(fact);
        return fact;
    }


    public List<Fact> getFactsBetween(long user_id, Date data1, Date data2) {
        return factRepo.findFacts(user_id, data1, data2);
    }

    public void DeleteFactBetween(long user_id, long id) {
        factRepo.delFact(user_id, id);
    }
}
