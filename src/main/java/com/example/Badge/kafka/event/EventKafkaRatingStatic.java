package com.example.Badge.kafka.event;

import com.example.Badge.model.RatingStatic;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaRatingStatic {
    private Action action;
    private RatingStatic data;
}
