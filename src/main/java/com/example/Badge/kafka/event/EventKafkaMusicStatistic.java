package com.example.Badge.kafka.event;

import com.example.Badge.model.MusicStatistic;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventKafkaMusicStatistic {
    private Action action;
    private MusicStatistic data;
}
