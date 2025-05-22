package com.example.Badge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "events")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    private String profilId;
    private String userId;
    private String eventId;
    private String eventType;

}
