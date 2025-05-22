package com.example.Badge.controller;

import com.example.Badge.model.MusicStatistic;
import com.example.Badge.service.MusicStatisticService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/music-stats")
public class MusicStatisticController {

    private final MusicStatisticService musicStatisticService;

    public MusicStatisticController(MusicStatisticService musicStatisticService) {
        this.musicStatisticService = musicStatisticService;
    }

    @GetMapping
    public List<MusicStatistic> getAll() {
        return musicStatisticService.getAll();
    }

    @PostMapping
    public MusicStatistic save(@RequestBody MusicStatistic musicStatistic) {
        return musicStatisticService.save(musicStatistic);
    }
}
