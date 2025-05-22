package com.example.Badge.repository;

import com.example.Badge.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByProfilId(String profilId);
}
