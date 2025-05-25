package com.example.Badge.repository;

import com.example.Badge.model.Badge;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/** The interface Badge repository. */
@Repository
public interface BadgeRepository extends MongoRepository<Badge, String> {
  /**
   * Find by profil id list.
   *
   * @param profilId the profil id
   * @return the list
   */
  // Rechercher les badges par profilId
  List<Badge> findByProfilId(String profilId);
}
