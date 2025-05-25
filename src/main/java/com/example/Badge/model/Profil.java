package com.example.Badge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Profil.
 */
@Document(collection = "profils")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Profil {

  /**
   * The Profil id.
   */
  @Id private String profilId;
  /**
   * The Description.
   */
  private String description;
  /**
   * The User id.
   */
  private String userId;

  /**
   * Gets profil id.
   *
   * @return the profil id
   */
  public String getProfilId() {
    return profilId;
  }

  /**
   * Sets profil id.
   *
   * @param profilId the profil id
   */
  public void setProfilId(String profilId) {
    this.profilId = profilId;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
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
}
