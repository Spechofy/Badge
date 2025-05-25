package com.example.Badge.controller;

import com.example.Badge.model.CommentsStatic;
import com.example.Badge.service.CommentsStaticService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * The type Comments static controller.
 */
@RestController
@RequestMapping("/comments")
public class CommentsStaticController {

    /**
     * The Comments static service.
     */
    private final CommentsStaticService commentsStaticService;

    /**
     * Instantiates a new Comments static controller.
     *
     * @param commentsStaticService the comments static service
     */
    public CommentsStaticController
    (final CommentsStaticService commentsStaticService) {
        this.commentsStaticService = commentsStaticService;
    }

    /**
     * Gets comments by user.
     *
     * @param userId the user id
     * @return the comments by user
     */
    @GetMapping("/user/{userId}")
    public List<CommentsStatic>
    getCommentsByUser(@PathVariable final String userId) {
        return commentsStaticService.getCommentsByUserId(userId);
    }

    /**
     * Save comment comments static.
     *
     * @param comment the comment
     * @return the comments static
     */
    @PostMapping
    public CommentsStatic
    saveComment(@RequestBody final CommentsStatic comment) {
        return commentsStaticService.saveComment(comment);
    }
}
