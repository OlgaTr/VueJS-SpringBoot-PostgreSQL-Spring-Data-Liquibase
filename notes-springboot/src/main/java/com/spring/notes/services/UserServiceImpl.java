package com.spring.notes.services;

import com.spring.notes.entities.User;
import com.spring.notes.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public User findByName(String username) {
        return userRepository.findByName(username);
    }
}
