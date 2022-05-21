package com.vinne.solutions.Mps.presenter.controller;

import com.vinne.solutions.Mps.infra.model.UserModel;
import com.vinne.solutions.Mps.infra.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()

public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @PostMapping(value = "/singup",consumes = "application/json")
    public ResponseEntity<String> newUser(@RequestBody UserModel user) {

        return userService.createUser(user);
    }
}
