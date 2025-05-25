package com.example.Badge.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Profil.
 */
@Document(collection = "profils")
@Builder
@Data
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

}
