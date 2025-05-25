package com.example.Badge.repository;

import com.example.Badge.model.Event;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

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
