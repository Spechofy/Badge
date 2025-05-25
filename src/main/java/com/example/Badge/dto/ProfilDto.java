package com.example.Badge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Profil dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfilDto {

  /**
   * The Profil id.
   */
  private String profilId;
  /**
   * The Description.
   */
  private String description;
  /**
   * The User id.
   */
  private String userId;
}
