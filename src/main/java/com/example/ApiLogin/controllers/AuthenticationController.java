package com.example.ApiLogin.controllers;

import com.example.ApiLogin.entities.*;
import com.example.ApiLogin.infra.security.JWTGenerator;
import com.example.ApiLogin.repositories.UserRepository;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserRepository repository;
    @Autowired
    private JWTGenerator jwtGenerator;

    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody @Valid LoginRequestDTO request, HttpServletResponse response){
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.username(), request.password());
        var authentication = authenticationManager.authenticate(usernamePassword);

        var token = jwtGenerator.generateToken((User) authentication.getPrincipal());

        Cookie cookie = new Cookie("JWT", token);

        cookie.setHttpOnly(true);
        cookie.setMaxAge(JWTConstants.JWT_EXPIRATION / 1000);
        cookie.setPath("/");

        response.addCookie(cookie);

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString()).build();
    }

    @PostMapping(value = "/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(repository.findByUsername(data.username()) != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.username(), data.email(), encryptedPassword);

        repository.save(newUser);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}


