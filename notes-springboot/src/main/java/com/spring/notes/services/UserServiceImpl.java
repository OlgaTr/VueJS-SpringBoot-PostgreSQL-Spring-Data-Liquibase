package com.spring.notes.services;

import com.spring.notes.entities.User;
import com.spring.notes.repositories.NotebookRepository;
import com.spring.notes.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final NotebookRepository notebookRepository;

    public UserServiceImpl(UserRepository userRepository, NotebookRepository notebookRepository) {
        this.userRepository = userRepository;
        this.notebookRepository = notebookRepository;
    }

    @Override
    public void addUser(User user) {
        userRepository.addUser(user.username(), user.password());
        notebookRepository.createNotebook(user.username());
    }

    @Override
    public User findByName(String username) {
        return userRepository.findByName(username);
    }

}
