package com.example.mall.admin.repository;

import com.example.mall.admin.model.TutorialDemo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Author saino
 * Create 12:06
 * update: 2022/9/5 12:20
 */
public interface TutorialDemoRepository extends MongoRepository<TutorialDemo, String> {
    List<TutorialDemo> findByTitleContaining(String title);
    List<TutorialDemo> findByPublished(boolean published);
}
