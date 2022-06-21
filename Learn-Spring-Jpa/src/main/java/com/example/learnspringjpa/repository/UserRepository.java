package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
