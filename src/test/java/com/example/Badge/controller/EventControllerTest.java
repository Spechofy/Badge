package com.example.Badge.controller;

import com.example.Badge.model.Event;
import com.example.Badge.service.EventService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EventControllerTest {

    @Mock
    private EventService eventService;

    @InjectMocks
    private EventController eventController;

    @BeforeEach
    void setUp() {
        // Rien à faire ici si on teste les méthodes directement
    }

    @Test
    void testCreateEvent() {
        Event event = new Event();
        when(eventService.saveEvent(event)).thenReturn(event);

        Event result = eventController.createEvent(event);

        assertNotNull(result);
        verify(eventService, times(1)).saveEvent(event);
    }

    @Test
    void testGetEventsByProfil() {
        List<Event> events = List.of(new Event(), new Event());
        when(eventService.getEventsByProfilId("profil123")).thenReturn(events);

        List<Event> result = eventController.getEventsByProfil("profil123");

        assertEquals(2, result.size());
        verify(eventService, times(1)).getEventsByProfilId("profil123");
    }

    @Test
    void testGetAllEvents() {
        List<Event> events = List.of(new Event());
        when(eventService.getAllEvents()).thenReturn(events);

        List<Event> result = eventController.getAllEvents();

        assertEquals(1, result.size());
        verify(eventService, times(1)).getAllEvents();
    }
}
