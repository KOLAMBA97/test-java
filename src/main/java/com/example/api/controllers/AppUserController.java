package com.example.api.controllers;

import com.example.api.entity.AppUser;
import com.example.api.resp.Message;
import com.example.api.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class AppUserController {

    @Autowired
    AppUserService appUserService;

    @GetMapping
    public List<AppUser> getUsers() {
        return appUserService.getUsers();
    }

    @PostMapping("/add")
    public ResponseEntity<?> createUser(@RequestBody AppUser appUser) {
        AppUser user = appUserService.createUser(appUser.getUsername(), appUser.getPassword());
        if (user == null) {
            return new ResponseEntity<>(new Message("Пользователь уже существует"), HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }

    @PostMapping("/get")
    public AppUser getUserByUsername(@RequestBody AppUser appUser) {
        return appUserService.GetUserByUsername(appUser.getUsername());
    }




}
