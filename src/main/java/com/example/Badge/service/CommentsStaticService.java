package com.example.Badge.service;

import com.example.Badge.model.CommentsStatic;
import com.example.Badge.repository.CommentsStaticRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentsStaticService {

    private final CommentsStaticRepository commentsStaticRepository;

    public CommentsStaticService(CommentsStaticRepository commentsStaticRepository) {
        this.commentsStaticRepository = commentsStaticRepository;
    }

    public List<CommentsStatic> getCommentsByUserId(String userId) {
        return commentsStaticRepository.findByUserId(userId);
    }

    public CommentsStatic saveComment(CommentsStatic comment) {
        return commentsStaticRepository.save(comment);
    }
}
