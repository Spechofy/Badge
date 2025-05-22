package com.example.Badge.service;

import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaCommentsStatic;
import com.example.Badge.kafka.Topics;
import com.example.Badge.model.CommentsStatic;
import com.example.Badge.repository.CommentsStaticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentsStaticService {

    @Autowired
    private  CommentsStaticRepository commentsStaticRepository;

    @Autowired
    private KafkaTemplate<String, EventKafkaCommentsStatic> kafkaTemplate;


    public List<CommentsStatic> getCommentsByUserId(String userId) {
        return commentsStaticRepository.findByUserId(userId);
    }

    public CommentsStatic saveComment(CommentsStatic comment) {
        kafkaTemplate.send(Topics.COMMENT,new EventKafkaCommentsStatic(Action.CREATE, comment));
        return comment;
    }
}
