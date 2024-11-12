package com.example.demo.controller;

import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
    System.out.println("Login attempt by: " + username);
    if (loginService.validateUser(username, password)) {
        return ResponseEntity.ok("Login Successful");
    } else {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Invalid Credentials");
    }
}
}