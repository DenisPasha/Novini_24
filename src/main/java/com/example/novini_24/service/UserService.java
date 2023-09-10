package com.example.novini_24.service;

import com.example.novini_24.config.CurrentUser;
import com.example.novini_24.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser ;

    public UserService(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


}
