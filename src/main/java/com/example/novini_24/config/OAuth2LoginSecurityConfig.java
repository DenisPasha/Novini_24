package com.example.novini_24.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
public class OAuth2LoginSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/css/**", "/js/**").permitAll()
                        .requestMatchers("/**").permitAll()
                        .requestMatchers("/login").anonymous()
                        .anyRequest().authenticated()
                )
                .oauth2Login(auth -> auth
                        .loginPage("/login")
                        .permitAll())
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll());

        return http.build();
    }

}
