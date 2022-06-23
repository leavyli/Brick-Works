package com.example.learnspringjpa.repository;

import com.example.learnspringjpa.entities.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
}