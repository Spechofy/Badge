package com.example.Badge.model;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Comments static.
 */
@Document
@Builder
@Data
public class CommentsStatic {
    /**
     * The Comments id.
     */
    private String commentsId;
    /**
     * The Content.
     */
    private String content;
    /**
     * The Date posted.
     */
    private LocalDateTime datePosted;
    /**
     * The Rate.
     */
    private int rate;
    /**
     * The User id.
     */
    private String userId;
    /**
     * The Playlist id.
     */
    private String playlistId;


}
