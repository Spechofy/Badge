package com.example.Badge.controller;

import com.example.Badge.model.CommentsStatic;
import com.example.Badge.service.CommentsStaticService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentsStaticController {

    private final CommentsStaticService commentsStaticService;

    public CommentsStaticController(CommentsStaticService commentsStaticService) {
        this.commentsStaticService = commentsStaticService;
    }

    @GetMapping("/user/{userId}")
    public List<CommentsStatic> getCommentsByUser(@PathVariable String userId) {
        return commentsStaticService.getCommentsByUserId(userId);
    }

    @PostMapping
    public CommentsStatic saveComment(@RequestBody CommentsStatic comment) {
        return commentsStaticService.saveComment(comment);
    }
}
