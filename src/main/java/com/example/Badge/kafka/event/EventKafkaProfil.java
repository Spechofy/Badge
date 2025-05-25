package com.example.Badge.kafka.event;

import com.example.Badge.model.Profil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Event kafka profil.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaProfil {
    /**
     * The Action.
     */
    private Action action;
    /**
     * The Data.
     */
    private Profil data;
}
