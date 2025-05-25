package com.example.Badge.kafka.event;

import com.example.Badge.model.CommentsStatic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Event kafka comments static.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaCommentsStatic {
    /**
     * The Action.
     */
    private Action action;
    /**
     * The Data.
     */
    private CommentsStatic data;
}
