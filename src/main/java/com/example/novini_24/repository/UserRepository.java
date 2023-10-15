package com.example.novini_24.repository;


import com.example.novini_24.model.entities.CustomCreatedUser;
import com.example.novini_24.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<CustomCreatedUser, Long> {
     boolean existsByEmail(String email);
     boolean existsByEmailAndPassword(String email, String password);
     void save(User user);
}
