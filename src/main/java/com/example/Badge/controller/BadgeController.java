package com.example.Badge.controller;

import com.example.Badge.model.Badge;
import com.example.Badge.service.BadgeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The type Badge controller.
 */
@RestController
@RequestMapping("/api/badges")
public class BadgeController {

    @Autowired
    private BadgeService badgeService;


    /**
     * Gets all badges.
     *
     * @return the all badges
     */
    @GetMapping
    public List<Badge> getAllBadges() {
        return badgeService.getAllBadges();
    }

    /**
     * Gets badge by id.
     *
     * @param id the id
     * @return the badge by id
     */
    @GetMapping("/{id}")
    public ResponseEntity<Badge> getBadgeById(@PathVariable String id) {
        return badgeService.getBadgeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Gets badges by profil id.
     *
     * @param profilId the profil id
     * @return the badges by profil id
     */
    @GetMapping("/profil/{profilId}")
    public List<Badge> getBadgesByProfilId(@PathVariable String profilId) {
        return badgeService.getBadgesByProfilId(profilId);
    }


    /**
     * Delete badge response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBadge(@PathVariable String id) {
        badgeService.deleteBadge(id);
        return ResponseEntity.noContent().build();
    }
}

