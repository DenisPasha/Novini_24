package com.example.novini_24.service;

import com.example.novini_24.config.CurrentUser;
import com.example.novini_24.model.entities.CustomCreatedUser;
import com.example.novini_24.model.entities.User;
import com.example.novini_24.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;
    private final ModelMapper modelMapper;


    public UserService(UserRepository userRepository, CurrentUser currentUser, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
        this.modelMapper = modelMapper;
    }


    public void checkUser(OAuth2AuthenticationToken auth2AuthenticationToken) {

        User user = new CustomCreatedUser();
        user.setUserName(auth2AuthenticationToken.getPrincipal().getAttribute("name"));
        user.setEmail(auth2AuthenticationToken.getPrincipal().getAttribute("email"));


        boolean userExists = userRepository.existsByEmail(user.getEmail());
        if (!userExists){
            userRepository.save(user);
        }

    }

    public void checkUser(User customCreatedUser) {
        if (!userRepository.existsByEmailAndPassword(customCreatedUser.getEmail(), customCreatedUser.getPassword())) {
            userRepository.save(customCreatedUser);
        }
        // TODO check if custom user is added to DB
    }
}
