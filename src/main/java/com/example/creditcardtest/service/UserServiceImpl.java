package com.example.creditcardtest.service;

import com.example.creditcardtest.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserServiceImpl(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAll() {
        return userService.getAll();
    }

    public User save(User user) {
        return userService.saveOrUpdate(user);
    }

    public User update(User user) {
        return userService.saveOrUpdate(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> user = userService.findByUsername(username);
        if (user.isEmpty()) throw new UsernameNotFoundException(username);
        return org.springframework.security.core.userdetails.User
                .withUsername(user.get().getEmail())
                .password(user.get().getPassword())
                .authorities(new SimpleGrantedAuthority("Admin"))
                .build();
    }
}
