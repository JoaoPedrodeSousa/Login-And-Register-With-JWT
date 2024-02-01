package com.example.AuthAPI.model.Controllers;

import com.example.AuthAPI.model.Entities.LoginReq;
import com.example.AuthAPI.model.Security.JWTGenerator;
import com.example.AuthAPI.model.Services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("auth")
public class AuthenticatorController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CustomUserDetailsService customUserDetailsService;
    @Autowired
    private JWTGenerator jwtGenerator;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginReq req){
        
    }
}
