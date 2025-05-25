package com.example.Badge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Event.
 */
@Document(collection = "events")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    /**
     * The Profil id.
     */
    private String profilId;
    /**
     * The User id.
     */
    private String userId;
    /**
     * The Event id.
     */
    private String eventId;
    /**
     * The Event type.
     */
    private String eventType;
}
