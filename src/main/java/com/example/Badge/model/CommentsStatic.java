package com.example.Badge.model;

import java.time.LocalDateTime;
import org.springframework.data.mongodb.core.mapping.Document;

/** The type Comments static. */
@Document
public class CommentsStatic {
  private String commentsId;
  private String content;
  private LocalDateTime datePosted;
  private int rate;
  private String userId;
  private String playlistId;

  /**
   * Gets comments id.
   *
   * @return the comments id
   */
  public String getCommentsId() {
    return commentsId;
  }

  /**
   * Sets comments id.
   *
   * @param commentsId the comments id
   */
  public void setCommentsId(String commentsId) {
    this.commentsId = commentsId;
  }

  /**
   * Gets content.
   *
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * Sets content.
   *
   * @param content the content
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * Gets date posted.
   *
   * @return the date posted
   */
  public LocalDateTime getDatePosted() {
    return datePosted;
  }

  /**
   * Sets date posted.
   *
   * @param datePosted the date posted
   */
  public void setDatePosted(LocalDateTime datePosted) {
    this.datePosted = datePosted;
  }

  /**
   * Gets rate.
   *
   * @return the rate
   */
  public int getRate() {
    return rate;
  }

  /**
   * Sets rate.
   *
   * @param rate the rate
   */
  public void setRate(int rate) {
    this.rate = rate;
  }

  /**
   * Gets user id.
   *
   * @return the user id
   */
  public String getUserId() {
    return userId;
  }

  /**
   * Sets user id.
   *
   * @param userId the user id
   */
  public void setUserId(String userId) {
    this.userId = userId;
  }

  /**
   * Gets playlist id.
   *
   * @return the playlist id
   */
  public String getPlaylistId() {
    return playlistId;
  }

  /**
   * Sets playlist id.
   *
   * @param playlistId the playlist id
   */
  public void setPlaylistId(String playlistId) {
    this.playlistId = playlistId;
  }
}
