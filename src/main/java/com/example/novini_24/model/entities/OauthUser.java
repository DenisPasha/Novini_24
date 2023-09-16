package com.example.novini_24.model.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class OauthUser extends User {


    public OauthUser(String username, String email) {
        super(username, email);
    }

    public OauthUser() {
        super();
    }
}
