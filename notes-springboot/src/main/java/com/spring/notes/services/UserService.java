package com.spring.notes.services;

import com.spring.notes.entities.User;

public interface UserService {
    void addUser(User user);
    User findByName(String username);
}
