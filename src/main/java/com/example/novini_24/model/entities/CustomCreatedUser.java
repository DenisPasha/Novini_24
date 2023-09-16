package com.example.novini_24.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class CustomCreatedUser extends User {

    @Column(name = "password")
    private String password;

    public CustomCreatedUser(String username, String email, String password) {
        super();
        this.password = password;
    }

    public CustomCreatedUser() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
