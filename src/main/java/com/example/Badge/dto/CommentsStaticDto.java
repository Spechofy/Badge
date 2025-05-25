package com.example.Badge.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The type Comments static dto. */
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
