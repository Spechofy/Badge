package com.example.Badge.service;

import com.example.Badge.model.Badge;
import com.example.Badge.repository.BadgeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BadgeService {

    private final BadgeRepository badgeRepository;

    public BadgeService(BadgeRepository badgeRepository) {
        this.badgeRepository = badgeRepository;
    }

    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    public Optional<Badge> getBadgeById(String id) {
        return badgeRepository.findById(id);
    }

    public List<Badge> getBadgesByProfilId(String profilId) {
        return badgeRepository.findByProfilId(profilId);
    }

    public Badge createBadge(Badge badge) {
        return badgeRepository.save(badge);
    }

    public Badge updateBadge(String id, Badge updatedBadge) {
        return badgeRepository.findById(id).map(badge -> {
            badge.setBadgeName(updatedBadge.getBadgeName());
            badge.setProfilId(updatedBadge.getProfilId());
            badge.setRatingStatic(updatedBadge.getRatingStatic());
            badge.setCommentsStatic(updatedBadge.getCommentsStatic());
            badge.setMusicStatistics(updatedBadge.getMusicStatistics());
            return badgeRepository.save(badge);
        }).orElseThrow(() -> new RuntimeException("Badge not found"));
    }

    public void deleteBadge(String id) {
        badgeRepository.deleteById(id);
    }
}

