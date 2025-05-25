package com.example.Badge.kafka.event;

import com.example.Badge.model.Profil;
import lombok.*;


/**
 * The type Event kafka profil.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaProfil {
    private Action action;
    private Profil data;
}
