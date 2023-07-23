package com.fyp.controller;

import com.fyp.dto.UserLoginDTO;
import com.fyp.response.LoginResponse;
import com.fyp.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Validated
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO) {

        LoginResponse loginResponse = loginService.login(userLoginDTO);

        return ResponseEntity.ok(loginResponse);
    }

}
