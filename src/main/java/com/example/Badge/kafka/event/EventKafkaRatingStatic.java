package com.example.Badge.kafka.event;

import com.example.Badge.model.RatingStatic;
import lombok.*;

/**
 * The type Event kafka rating static.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaRatingStatic {
    /**
     * The Action.
     */
    private Action action;
    /**
     * The Data.
     */
    private RatingStatic data;
}
