package com.example.Badge.kafka.event;

import com.example.Badge.model.CommentsStatic;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaCommentsStatic {
    private Action action;
    private CommentsStatic data;
}
