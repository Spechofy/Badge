package com.example.Badge.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Comments static dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsStaticDto {
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
