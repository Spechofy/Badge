package com.example.Badge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsStaticDto {
    private String commentsId;
    private String content;
    private LocalDateTime datePosted;
    private int rate;
    private String userId;
    private String playlistId;
}
