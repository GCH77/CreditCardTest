package com.example.creditcardtest.config;

import com.example.creditcardtest.entity.User;
import com.example.creditcardtest.service.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    CommandLineRunner commandLineRunner(UserServiceImpl userService) {
        return args -> {
            User user = new User(1L, "test@mail.com", new BCryptPasswordEncoder().encode("test123"));
            userService.save(user);
        };
    }
}
