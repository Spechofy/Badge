package com.example.Badge.controller;

import com.example.Badge.model.MusicStatistic;
import com.example.Badge.service.MusicStatisticService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class MusicStatisticControllerTest {

    @Mock
    private MusicStatisticService musicStatisticService;

    @InjectMocks
    private MusicStatisticController musicStatisticController;

    @BeforeEach
    void setUp() {
        // Pas besoin de setup particulier ici
    }

    @Test
    void testGetAll() {
        List<MusicStatistic> stats = List.of(new MusicStatistic(), new MusicStatistic());
        when(musicStatisticService.getAll()).thenReturn(stats);

        List<MusicStatistic> result = musicStatisticController.getAll();

        assertEquals(2, result.size());
        verify(musicStatisticService, times(1)).getAll();
    }

    @Test
    void testSave() {
        MusicStatistic stat = new MusicStatistic();
        when(musicStatisticService.save(stat)).thenReturn(stat);

        MusicStatistic result = musicStatisticController.save(stat);

        assertNotNull(result);
        verify(musicStatisticService, times(1)).save(stat);
    }
}
