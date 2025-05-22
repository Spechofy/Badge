package com.example.Badge.repository;

import com.example.Badge.model.RatingStatic;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RatingStaticRepository extends MongoRepository<RatingStatic, String> {
    List<RatingStatic> findByRateGreaterThan(int minRate);
}
