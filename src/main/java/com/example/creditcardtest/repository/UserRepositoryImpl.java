package com.example.creditcardtest.repository;

import com.example.creditcardtest.entity.User;
import com.example.creditcardtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserService {
    private final UserCrudRepository userCrudRepository;

    @Autowired
    public UserRepositoryImpl(UserCrudRepository userCrudRepository) {
        this.userCrudRepository = userCrudRepository;
    }

    @Override
    public List<User> getAll() {
        return userCrudRepository.findAll();
    }

    @Override
    public User saveOrUpdate(User user) {
        return userCrudRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userCrudRepository.findByEmail(username);
    }
}
