package com.example.Badge.kafka.event;

import com.example.Badge.model.Event;
import com.example.Badge.model.Profil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The type Event kafka event.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaEvent {
    private Action action;
    private Event data;
}
