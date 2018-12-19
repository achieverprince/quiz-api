package com.achieverprince.quiz.entity;

import com.achieverprince.quiz.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private ApplicationUserRepository userRepository;

    @GetMapping("/users")
    public List<ApplicationUser> retrieveAllUsers() {
        return userRepository.findAll();
    }
}
