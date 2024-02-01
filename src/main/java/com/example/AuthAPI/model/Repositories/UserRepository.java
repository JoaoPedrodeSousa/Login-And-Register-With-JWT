package com.example.AuthAPI.model.Repositories;

import com.example.AuthAPI.model.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<UserDetails> findByUsername(String username);
}
