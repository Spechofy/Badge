package com.example.Badge.service;

import com.example.Badge.model.RatingStatic;
import com.example.Badge.repository.RatingStaticRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingStaticService {

    private final RatingStaticRepository ratingStaticRepository;

    public RatingStaticService(RatingStaticRepository ratingStaticRepository) {
        this.ratingStaticRepository = ratingStaticRepository;
    }

    public List<RatingStatic> getPositiveRatings(int minRate) {
        return ratingStaticRepository.findByRateGreaterThan(minRate);
    }

    public RatingStatic saveRating(RatingStatic rating) {
        return ratingStaticRepository.save(rating);
    }
}
