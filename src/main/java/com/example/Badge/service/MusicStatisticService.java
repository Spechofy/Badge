package com.example.Badge.service;

import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaMusicStatistic;
import com.example.Badge.kafka.Topics;
import com.example.Badge.model.MusicStatistic;
import com.example.Badge.repository.MusicStatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicStatisticService {

    @Autowired
    private MusicStatisticRepository musicStatisticRepository;
    @Autowired
    private KafkaTemplate<String, EventKafkaMusicStatistic> kafkaTemplate;

    public List<MusicStatistic> getAll() {
        return musicStatisticRepository.findAll();
    }

    public MusicStatistic save(MusicStatistic musicStatistic) {
        kafkaTemplate.send(Topics.MUSIC, new EventKafkaMusicStatistic(Action.CREATE,musicStatistic));
        return musicStatistic;
    }
}
