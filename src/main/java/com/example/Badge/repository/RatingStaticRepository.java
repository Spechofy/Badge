package com.example.Badge.repository;

import com.example.Badge.model.RatingStatic;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

/**
 * The interface Rating static repository.
 */
public interface RatingStaticRepository extends MongoRepository<RatingStatic, String> {
    /**
     * Find by rate greater than list.
     *
     * @param minRate the min rate
     * @return the list
     */
    List<RatingStatic> findByRateGreaterThan(int minRate);
}
