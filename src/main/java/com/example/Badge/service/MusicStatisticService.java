package com.example.Badge.service;

import com.example.Badge.kafka.Topics;
import com.example.Badge.kafka.event.Action;
import com.example.Badge.kafka.event.EventKafkaMusicStatistic;
import com.example.Badge.model.MusicStatistic;
import com.example.Badge.repository.MusicStatisticRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Music statistic service.
 */
@Service
public class MusicStatisticService {

    /**
     * The Music statistic repository.
     */
    @Autowired
    private MusicStatisticRepository musicStatisticRepository;
    /**
     * The Kafka template.
     */
    @Autowired
    private KafkaTemplate<String, EventKafkaMusicStatistic> kafkaTemplate;

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<MusicStatistic> getAll() {
        return musicStatisticRepository.findAll();
    }

    /**
     * Save music statistic.
     *
     * @param musicStatistic the music statistic
     * @return the music statistic
     */
    public MusicStatistic save(final MusicStatistic musicStatistic) {
        kafkaTemplate.send(Topics.MUSIC,
                new EventKafkaMusicStatistic(Action.CREATE, musicStatistic));
        return musicStatistic;
    }
}
