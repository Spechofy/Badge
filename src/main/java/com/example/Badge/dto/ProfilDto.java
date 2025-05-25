package com.example.Badge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** The type Profil dto. */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfilDto {

  private String profilId;
  private String description;
  private String userId;
}
