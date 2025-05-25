package com.example.Badge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Rating static dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingStaticDto {
  /**
   * The Rating id.
   */
  private String ratingId;
  /**
   * The Comment.
   */
  private String comment;
  /**
   * The Rate.
   */
  private int rate;
}
