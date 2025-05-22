package com.example.Badge.service;

import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaRatingStatic;
import com.example.Badge.kafka.Topics;
import com.example.Badge.model.RatingStatic;
import com.example.Badge.repository.RatingStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RatingStaticService {

    @Autowired
    private RatingStaticRepository ratingStaticRepository;

    @Autowired
    private KafkaTemplate<String, EventKafkaRatingStatic > kafkaTemplate;

    public List<RatingStatic> getPositiveRatings(int minRate) {
        return ratingStaticRepository.findByRateGreaterThan(minRate);
    }

    public RatingStatic saveRating(RatingStatic rating) {

        kafkaTemplate.send(Topics.RATING, new EventKafkaRatingStatic(Action.CREATE, rating));
        return rating;
    }
}
