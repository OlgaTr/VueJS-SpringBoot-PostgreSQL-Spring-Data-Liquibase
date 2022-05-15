package com.spring.notes.controllers;

import com.spring.notes.entities.User;
import com.spring.notes.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public void logInUser(@RequestBody User user) {
        userService.setCurrentUser(user);
    }

    @DeleteMapping("/logout")
    public void logOutUser() {
        userService.cleanCurrentUser();
    }

    @GetMapping("/login")
    public User currentUser() {
        return userService.getCurrentUser();
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
