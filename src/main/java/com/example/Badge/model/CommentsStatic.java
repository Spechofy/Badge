package com.example.Badge.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class CommentsStatic {
    private String commentsId;
    private String content;
    private LocalDateTime datePosted;
    private int rate;
    private String userId;
    private String playlistId;
}
