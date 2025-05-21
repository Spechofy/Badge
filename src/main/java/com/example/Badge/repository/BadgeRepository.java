package com.example.Badge.repository;

import com.example.Badge.model.Badge;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BadgeRepository extends MongoRepository<Badge, String> {
    // Rechercher les badges par profilId
    List<Badge> findByProfilId(String profilId);
}

