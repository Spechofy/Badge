package com.example.Badge.service;

import com.example.Badge.model.MusicStatistic;
import com.example.Badge.repository.MusicStatisticRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MusicStatisticService {

    private final MusicStatisticRepository musicStatisticRepository;

    public MusicStatisticService(MusicStatisticRepository musicStatisticRepository) {
        this.musicStatisticRepository = musicStatisticRepository;
    }

    public List<MusicStatistic> getAll() {
        return musicStatisticRepository.findAll();
    }

    public MusicStatistic save(MusicStatistic musicStatistic) {
        return musicStatisticRepository.save(musicStatistic);
    }
}
