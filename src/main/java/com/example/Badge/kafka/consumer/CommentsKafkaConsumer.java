package com.example.Badge.kafka.consumer;

import com.example.Badge.kafka.Topics;
import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaCommentsStatic;
import com.example.Badge.model.CommentsStatic;
import com.example.Badge.repository.CommentsStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * The type Comments kafka consumer.
 */
@Service
public class CommentsKafkaConsumer {

  /**
   * The Comments static repository.
   */
  @Autowired private CommentsStaticRepository commentsStaticRepository;

  /**
   * Consume comment.
   *
   * @param event the event
   */
  @KafkaListener(topics = Topics.COMMENT, groupId = "spechofy-group")
  public void consumeComment(final EventKafkaCommentsStatic event) {
    Action action = event.getAction();
    CommentsStatic comment = event.getData();
    switch (action) {
      case CREATE:
        commentsStaticRepository.save(comment);
        break;
      default:
        break;
    }
  }
}
