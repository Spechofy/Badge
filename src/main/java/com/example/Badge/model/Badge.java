package com.example.Badge.model;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/** The type Badge. */
@Document(collection = "badges")
@Getter
@Setter
public class Badge {

  @Id private String badgeId;
  private String badgeName;

  private String profilId; // référence vers Profil

  private RatingStatic ratingStatic;
  private CommentsStatic commentsStatic;
  private List<MusicStatistic> musicStatistics;
}
