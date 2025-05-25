package com.example.Badge.repository;

import com.example.Badge.model.CommentsStatic;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * The interface Comments static repository.
 */
public interface CommentsStaticRepository extends MongoRepository<CommentsStatic, String> {
    /**
     * Find by user id list.
     *
     * @param userId the user id
     * @return the list
     */
    List<CommentsStatic> findByUserId(String userId);
}