package com.example.creditcardtest.repository;

import com.example.creditcardtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserCrudRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
}
