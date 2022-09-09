package com.example.mall.admin.repository.mongodb;

import com.example.mall.admin.model.mongodb.UserLoginRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserLoginRecordRepository extends MongoRepository<UserLoginRecord, String> {
}
