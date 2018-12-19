package com.achieverprince.quiz.entity;

import com.achieverprince.quiz.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private ApplicationUserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/users")
    public List<ApplicationUser> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @RequestMapping("/user/{userName}")
    public ApplicationUser retriveUserDetail(@PathVariable  String userName) {
        return userRepository.findByUserName(userName);
    }

    @RequestMapping("/createUser")
    public ApplicationUser createUser(@RequestBody ApplicationUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }
}
