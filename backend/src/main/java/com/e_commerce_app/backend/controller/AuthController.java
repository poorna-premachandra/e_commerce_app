package com.e_commerce_app.backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

import com.e_commerce_app.backend.service.UserService;
import com.e_commerce_app.backend.dto.UserSignupDTO;
import com.e_commerce_app.backend.dto.UserLoginDTO;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<HttpStatus> signup(@RequestBody UserSignupDTO userSignupDTO) {
        userService.signup(userSignupDTO);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO) {
        String token = userService.login(userLoginDTO);
        return ResponseEntity.ok(token);
    }
}
