package com.example.AuthAPI.model.Security;

import com.example.AuthAPI.model.Entities.JWTConstants;
import org.apache.tomcat.util.net.Constants;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Component;

@Component
public class JWTGenerator {

    @Autowired
    private AuthenticationManager manager;

    public String generateToken(Authentication authentication){
        String username = authentication.getName();
        Date currentDate = new Date();
        Date expire = new Date(currentDate.getTime() + JWTConstants.JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setExpiration(expire)
                .signWith(SignatureAlgorith.HS512, JWTConstants.JWT_SECRET).compact()
                .builder();
    }


}
