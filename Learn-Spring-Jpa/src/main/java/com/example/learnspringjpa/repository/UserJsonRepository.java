package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.UserJson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJsonRepository extends JpaRepository<UserJson, Long> {
    UserJson findByName(String name);
}