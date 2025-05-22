package com.example.Badge.repository;

import com.example.Badge.model.CommentsStatic;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CommentsStaticRepository extends MongoRepository<CommentsStatic, String> {
    List<CommentsStatic> findByUserId(String userId);
}