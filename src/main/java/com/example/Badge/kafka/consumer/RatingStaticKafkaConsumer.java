package com.example.Badge.kafka.consumer;

import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaRatingStatic;

import com.example.Badge.kafka.Topics;
import com.example.Badge.model.RatingStatic;
import com.example.Badge.repository.RatingStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RatingStaticKafkaConsumer {

    @Autowired
    private RatingStaticRepository ratingStaticRepository;

    @KafkaListener(topics = Topics.RATING, groupId = "spechofy-group")
    public void listenRatingStatic(EventKafkaRatingStatic event) {
        Action action = event.getAction();
        RatingStatic rating = event.getData();
        switch (action) {
            case CREATE -> ratingStaticRepository.save(rating);
        }
    }
}

