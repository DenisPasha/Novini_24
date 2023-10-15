package com.example.novini_24.config;


import com.example.novini_24.model.dto.UserDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AuthenticatedPrincipal;

@Configuration
public class CurrentUser {

    
    @Bean
    @Lazy
    public UserDto getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null){
            Object principal = authentication.getPrincipal();
            if (principal instanceof OAuth2AuthenticatedPrincipal){
                String name = ((OAuth2AuthenticatedPrincipal) principal).getAttribute("name");
                String email = ((OAuth2AuthenticatedPrincipal) principal).getAttribute("email");
                return new UserDto(name , email);
            }
        }

        return null;
    }
}
