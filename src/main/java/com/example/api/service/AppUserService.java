package com.example.api.service;

import com.example.api.entity.AppUser;
import com.example.api.repo.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {

    @Autowired
    private AppUserRepo appUserRepo;

    public List<AppUser> getUsers() {
        return appUserRepo.findAll();
    }

    public AppUser createUser(String username, String password) {
        AppUser candidate = appUserRepo.findByUsername(username);
        if (candidate == null) {
            AppUser user = new AppUser(username, password);
            appUserRepo.save(user);
            return user;
        } else return null;
    }

    public AppUser GetUserByUsername(String username) {
        return appUserRepo.findByUsername(username);
    }

}
