package com.example.Badge.repository;

import com.example.Badge.model.Profil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Profil repository.
 */
@Repository
public interface ProfilRepository extends MongoRepository<Profil, String> {
  /**
   * Find by user id profil.
   *
   * @param userId the user id
   * @return the profil
   */
  Profil findByUserId(String userId);
}
