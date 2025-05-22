package com.example.Badge.controller;


import com.example.Badge.model.Event;
import com.example.Badge.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@RequiredArgsConstructor
public class EventController {

    private final EventService eventService;

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventService.saveEvent(event);
    }

    @GetMapping("/profil/{profilId}")
    public List<Event> getEventsByProfil(@PathVariable String profilId) {
        return eventService.getEventsByProfilId(profilId);
    }

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }
}

