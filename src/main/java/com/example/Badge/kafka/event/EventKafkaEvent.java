package com.example.Badge.kafka.event;

import com.example.Badge.model.Event;
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
  /**
   * The Action.
   */
  private Action action;
  /**
   * The Data.
   */
  private Event data;
}
