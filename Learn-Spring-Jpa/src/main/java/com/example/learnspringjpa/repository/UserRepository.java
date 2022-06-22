package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.dto.UserOnlyEmailName;
import com.example.learnspringjpa.dto.UserOnlyName;
import com.example.learnspringjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    Iterable<User> findUserByName(String name);

    List<User> findUserByEmail(String email);

    UserOnlyEmailName findByEmail(String email);

    UserOnlyName findUserOnlyNameByEmail(String email);

}
