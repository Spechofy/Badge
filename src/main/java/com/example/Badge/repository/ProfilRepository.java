package com.example.Badge.repository;

import com.example.Badge.model.Profil;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilRepository extends MongoRepository<Profil, String> {
    Profil findByUserId(String userId);
}

