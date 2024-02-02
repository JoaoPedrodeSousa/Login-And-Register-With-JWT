package com.example.ApiLogin.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.ApiLogin.entities.JWTConstants;
import com.example.ApiLogin.entities.User;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class JWTGenerator {

    public String generateToken(User user){
        try{
            Algorithm algorithm = Algorithm.HMAC256(JWTConstants.JWT_SECRET);
            String token = JWT.create()
                    .withIssuer("AuthenticationAPI")
                    .withSubject(user.getUsername())
                    .withExpiresAt(Instant.ofEpochSecond(JWTConstants.JWT_EXPIRATION))
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error Token generator", exception);
        }
    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWTConstants.JWT_SECRET);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException exception){
            return "";
        }
    }

}
