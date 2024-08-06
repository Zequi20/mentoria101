package com.api.loginApi.apiRestLoginMentoria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.loginApi.apiRestLoginMentoria.models.UserModel;
import com.api.loginApi.apiRestLoginMentoria.services.UserService;

@RestController
@RequestMapping("/api/public")
public class PublicAuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody UserModel user) {
        try {
            UserModel registeredUser = userService.saveUser(user);
            return ResponseEntity.ok("User registrado");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}