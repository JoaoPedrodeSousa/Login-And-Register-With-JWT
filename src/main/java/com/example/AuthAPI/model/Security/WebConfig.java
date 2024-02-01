package com.example.AuthAPI.model.Security;

import com.example.AuthAPI.model.Entities.JWTConstants;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class WebConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .sessionManagement(SessionCreationPolicy.STATELESS)
                .authorizeHttpRequests(
                    authorize -> authorize
                                    .requestMatchers("/users")
                                    .hasRole("ROLE_ADMIN")
                                    .requestMatchers("/task/{id}").permitAll()
                                    .requestMatchers("/task").permitAll()
                                    .anyRequest().authenticated()
                );


        return http.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config){
        return config.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Component
    public static class JWTGenerator {

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
}
