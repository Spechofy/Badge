package com.example.Badge.controller;

import com.example.Badge.model.MusicStatistic;
import com.example.Badge.service.MusicStatisticService;

import java.util.List;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


/**
 * The type Music statistic controller.
 */
@RestController
@RequestMapping("/music-stats")
@RequiredArgsConstructor
public class MusicStatisticController {

    /**
     * The Music statistic service.
     */
    private final MusicStatisticService musicStatisticService;


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
    public MusicStatistic save(
            @RequestBody final MusicStatistic musicStatistic) {
        return musicStatisticService.save(musicStatistic);
    }
}
