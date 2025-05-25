package com.example.Badge.service;

import com.example.Badge.kafka.Topics;
import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaCommentsStatic;
import com.example.Badge.model.CommentsStatic;
import com.example.Badge.repository.CommentsStaticRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Comments static service.
 */
@Service
public class CommentsStaticService {

    /**
     * The Comments static repository.
     */
    @Autowired
    private CommentsStaticRepository commentsStaticRepository;

    /**
     * The Kafka template.
     */
    @Autowired
    private KafkaTemplate<String, EventKafkaCommentsStatic> kafkaTemplate;

    /**
     * Gets comments by user id.
     *
     * @param userId the user id
     * @return the comments by user id
     */
    public List<CommentsStatic> getCommentsByUserId(final String userId) {
        return commentsStaticRepository.findByUserId(userId);
    }

    /**
     * Save comment comments static.
     *
     * @param comment the comment
     * @return the comments static
     */
    public CommentsStatic saveComment(final CommentsStatic comment) {
        kafkaTemplate.send(Topics.COMMENT,
                new EventKafkaCommentsStatic(Action.CREATE, comment));
        return comment;
    }
}
