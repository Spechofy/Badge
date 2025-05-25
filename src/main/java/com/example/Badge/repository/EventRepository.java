package com.example.Badge.repository;

import com.example.Badge.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * The interface Event repository.
 */
public interface EventRepository extends MongoRepository<Event, String> {
    /**
     * Find by profil id list.
     *
     * @param profilId the profil id
     * @return the list
     */
    List<Event> findByProfilId(String profilId);
}
