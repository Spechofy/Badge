package com.example.Badge.kafka.consumer;

import com.example.Badge.kafka.Topics;
import com.example.Badge.kafka.event.EventKafkaEvent;
import com.example.Badge.model.Event;
import com.example.Badge.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * The type Event kafka consumer.
 */
@Service
public class EventKafkaConsumer {

  /**
   * The Even repository.
   */
  @Autowired private EventRepository evenRepository;

  /**
   * Listen event.
   *
   * @param eventKafka the event kafka
   */
  @KafkaListener(topics = Topics.EVENT, groupId = "spechofy-group")
  public void listenEvent(EventKafkaEvent eventKafka) {
    Event even = (Event) eventKafka.getData();
    switch (eventKafka.getAction()) {
      case CREATE:
        evenRepository.save(even);
        break;
      case DELETE:
        evenRepository.delete(even);
        break;
    }
  }
}
