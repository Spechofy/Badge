package com.example.Badge.controller;

import com.example.Badge.model.CommentsStatic;
import com.example.Badge.service.CommentsStaticService;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/** The type Comments static controller. */
@RestController
@RequestMapping("/comments")
public class CommentsStaticController {

  private final CommentsStaticService commentsStaticService;

  /**
   * Instantiates a new Comments static controller.
   *
   * @param commentsStaticService the comments static service
   */
  public CommentsStaticController(CommentsStaticService commentsStaticService) {
    this.commentsStaticService = commentsStaticService;
  }

  /**
   * Gets comments by user.
   *
   * @param userId the user id
   * @return the comments by user
   */
  @GetMapping("/user/{userId}")
  public List<CommentsStatic> getCommentsByUser(@PathVariable String userId) {
    return commentsStaticService.getCommentsByUserId(userId);
  }

  /**
   * Save comment comments static.
   *
   * @param comment the comment
   * @return the comments static
   */
  @PostMapping
  public CommentsStatic saveComment(@RequestBody CommentsStatic comment) {
    return commentsStaticService.saveComment(comment);
  }
}
