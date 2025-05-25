package com.example.Badge.controller;

import com.example.Badge.model.MusicStatistic;
import com.example.Badge.service.MusicStatisticService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Music statistic controller.
 */
@RestController
@RequestMapping("/music-stats")
public class MusicStatisticController {

    private final MusicStatisticService musicStatisticService;

    /**
     * Instantiates a new Music statistic controller.
     *
     * @param musicStatisticService the music statistic service
     */
    public MusicStatisticController(MusicStatisticService musicStatisticService) {
        this.musicStatisticService = musicStatisticService;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    @GetMapping
    public List<MusicStatistic> getAll() {
        return musicStatisticService.getAll();
    }

    /**
     * Save music statistic.
     *
     * @param musicStatistic the music statistic
     * @return the music statistic
     */
    @PostMapping
    public MusicStatistic save(@RequestBody MusicStatistic musicStatistic) {
        return musicStatisticService.save(musicStatistic);
    }
}
