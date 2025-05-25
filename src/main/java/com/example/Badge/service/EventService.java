package com.example.Badge.service;

import com.example.Badge.kafka.Topics;
import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaEvent;
import com.example.Badge.model.Event;
import com.example.Badge.repository.EventRepository;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Event service.
 */
@Service
@RequiredArgsConstructor
public class EventService {

    /**
     * The Event repository.
     */
    @Autowired
    private EventRepository eventRepository;

    /**
     * The Kafka template.
     */
    @Autowired
    private KafkaTemplate<String, EventKafkaEvent> kafkaTemplate;

    /**
     * Save event event.
     *
     * @param event the event
     * @return the event
     */
    public Event saveEvent(final Event event) {
        kafkaTemplate.send(Topics.EVENT,
                new EventKafkaEvent(Action.CREATE, event));
        return eventRepository.save(event);
    }

    /**
     * Gets events by profil id.
     *
     * @param profilId the profil id
     * @return the events by profil id
     */
    public List<Event> getEventsByProfilId(final String profilId) {
        return eventRepository.findByProfilId(profilId);
    }

    /**
     * Gets all events.
     *
     * @return the all events
     */
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    /**
     * Count events by profil id int.
     *
     * @param profilId the profil id
     * @return the int
     */
    public int countEventsByProfilId(final String profilId) {
        return getEventsByProfilId(profilId).size();
    }
}
