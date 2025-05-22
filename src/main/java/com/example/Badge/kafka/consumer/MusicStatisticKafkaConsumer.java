package com.example.Badge.kafka.consumer;

import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaMusicStatistic;
import com.example.Badge.model.MusicStatistic;
import com.example.Badge.repository.MusicStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MusicStatisticKafkaConsumer {

    @Autowired
    private MusicStatisticRepository musicStatisticRepository;

    @KafkaListener(topics = "music-stats-topic", groupId = "spechofy-group")
    public void listenMusicStatistic(EventKafkaMusicStatistic event) {
        Action action = event.getAction();
        MusicStatistic musicStatistic = event.getData();
        switch (action) {
            case CREATE -> musicStatisticRepository.save(musicStatistic);
        }
    }
}

