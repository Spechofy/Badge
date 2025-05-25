package com.example.Badge.repository;

import com.example.Badge.model.Badge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Badge repository.
 */
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

