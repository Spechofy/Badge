package com.example.Badge.service;

import com.example.Badge.kafka.Topics;
import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaEvent;
import com.example.Badge.model.Event;
import com.example.Badge.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private KafkaTemplate<String, EventKafkaEvent> kafkaTemplate;

    public Event saveEvent(Event event) {
        kafkaTemplate.send(Topics.EVENT, new EventKafkaEvent(Action.CREATE,event));
        return eventRepository.save(event);
    }

    public List<Event> getEventsByProfilId(String profilId) {
        return eventRepository.findByProfilId(profilId);
    }

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public int countEventsByProfilId(String profilId) {
        return getEventsByProfilId(profilId).size();
    }
}

