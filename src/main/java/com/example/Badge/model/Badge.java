package com.example.Badge.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Badge.
 */
@Document(collection = "badges")
@Getter
@Setter
public class Badge {

  /**
   * The Badge id.
   */
  @Id private String badgeId;
  /**
   * The Badge name.
   */
  private String badgeName;

  /**
   * The Profil id.
   */
  private String profilId; // référence vers Profil

  /**
   * The Rating static.
   */
  private RatingStatic ratingStatic;
  /**
   * The Comments static.
   */
  private CommentsStatic commentsStatic;
  /**
   * The Music statistics.
   */
  private List<MusicStatistic> musicStatistics;
}
