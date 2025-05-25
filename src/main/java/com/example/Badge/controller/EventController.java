package com.example.Badge.controller;

import com.example.Badge.model.Event;
import com.example.Badge.service.EventService;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * The type Event controller.
 */
@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    /**
     * The Event service.
     */
    private final EventService eventService;

    /**
     * Create event.
     *
     * @param event the event
     * @return the event
     */
    @PostMapping
    public Event createEvent(@RequestBody final Event event) {
        return eventService.saveEvent(event);
    }

    /**
     * Gets events by profil.
     *
     * @param profilId the profil id
     * @return the events by profil
     */
    @GetMapping("/profil/{profilId}")
    public List<Event> getEventsByProfil(@PathVariable final String profilId) {
        return eventService.getEventsByProfilId(profilId);
    }

    /**
     * Gets all events.
     *
     * @return the all events
     */
    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}
