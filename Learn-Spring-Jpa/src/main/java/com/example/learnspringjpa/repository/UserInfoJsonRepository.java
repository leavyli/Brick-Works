package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.UserInfoJson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoJsonRepository extends JpaRepository<UserInfoJson, Long> {
    UserInfoJson findBySchool(String hc);
}