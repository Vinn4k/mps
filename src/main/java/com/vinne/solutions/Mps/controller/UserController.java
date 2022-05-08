package com.vinne.solutions.Mps.controller;

import com.vinne.solutions.Mps.model.UserModel;
import com.vinne.solutions.Mps.services.UserService;
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
