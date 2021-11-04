package com.example.creditcardtest.service;

import com.example.creditcardtest.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();
    User saveOrUpdate(User user);
    Optional<User> findByUsername(String username);
}
