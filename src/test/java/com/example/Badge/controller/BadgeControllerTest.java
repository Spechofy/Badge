package com.example.Badge.controller;

import com.example.Badge.model.Badge;
import com.example.Badge.service.BadgeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BadgeControllerTest {

    private MockMvc mockMvc;


    @Mock
    private BadgeService badgeService;
    @InjectMocks
    private BadgeController badgeController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(badgeController).build();
    }

    @Test
    void testGetAllBadges() {
        List<Badge> badges = List.of(new Badge(), new Badge());
        when(badgeService.getAllBadges()).thenReturn(badges);

        List<Badge> result = badgeController.getAllBadges();

        assertEquals(2, result.size());
        verify(badgeService, times(1)).getAllBadges();
    }

    @Test
    void testGetBadgeById_found() {
        Badge badge = new Badge();
        when(badgeService.getBadgeById("123")).thenReturn(Optional.of(badge));

        ResponseEntity<Badge> response = badgeController.getBadgeById("123");

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(badge, response.getBody());
        verify(badgeService).getBadgeById("123");
    }

    @Test
    void testGetBadgeById_notFound() {
        when(badgeService.getBadgeById("123")).thenReturn(Optional.empty());

        ResponseEntity<Badge> response = badgeController.getBadgeById("123");

        assertEquals(404, response.getStatusCodeValue());
        assertNull(response.getBody());
    }

    @Test
    void testGetBadgesByProfilId() {
        List<Badge> badges = List.of(new Badge());
        when(badgeService.getBadgesByProfilId("profil1")).thenReturn(badges);

        List<Badge> result = badgeController.getBadgesByProfilId("profil1");

        assertEquals(1, result.size());
        verify(badgeService).getBadgesByProfilId("profil1");
    }

    @Test
    void testDeleteBadge() {
        doNothing().when(badgeService).deleteBadge("123");

        ResponseEntity<Void> response = badgeController.deleteBadge("123");

        assertEquals(204, response.getStatusCodeValue());
        verify(badgeService).deleteBadge("123");
    }
}
