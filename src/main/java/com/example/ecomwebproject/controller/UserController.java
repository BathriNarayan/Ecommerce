package com.example.ecomwebproject.controller;

import com.example.ecomwebproject.Model.Users;
import com.example.ecomwebproject.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService service;

   // @RequestMapping("/user")

    @PostMapping("/createuser")
    public ResponseEntity<String> postUser(@RequestBody Users u1) {
        Boolean u= service.createuser(u1);
        if(u) {
            System.out.println("User created successfully");
            return ResponseEntity.status(HttpStatus.OK).body("User created successfully " + u1);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User Already Exists with same name or ID");
        }

    }

}
