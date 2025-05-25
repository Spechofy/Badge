package com.example.Badge.service;

import com.example.Badge.model.*;
import com.example.Badge.repository.BadgeRepository;
import com.example.Badge.repository.ProfilRepository;
import com.example.Badge.service.assignment.BadgeAssigner;
import com.example.Badge.service.assignment.BadgeType;

import java.util.List;
import java.util.Optional;

import com.example.Badge.service.assignment.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Badge service.
 */
@Service
public class BadgeService {

    /**
     * The Badge repository.
     */
    @Autowired
    private BadgeRepository badgeRepository;

    /**
     * The Profil repository.
     */
    @Autowired
    private ProfilRepository profilRepository;

    /**
     * The Comments static service.
     */
    @Autowired
    private CommentsStaticService commentsStaticService;

    /**
     * The Rating static service.
     */
    @Autowired
    private RatingStaticService ratingStaticService;

    /**
     * The Music statistic service.
     */
    @Autowired
    private MusicStatisticService musicStatisticService;

    /**
     * The Event service.
     */
    @Autowired
    private EventService eventService;

    /**
     * Assign badges to profil.
     *
     * @param profilId the profil id
     */
    public void assignBadgesToProfil(final String profilId) {
        Profil profil =
                profilRepository
                        .findById(profilId)
                        .orElseThrow(() -> new RuntimeException(
                                "Profil non trouvé"));
        String userId = profil.getUserId();

        List<Badge> badgesExistants = badgeRepository
                .findByProfilId(profilId);
        List<CommentsStatic> userComments = commentsStaticService
                .getCommentsByUserId(userId);
        List<RatingStatic> positiveRatings = ratingStaticService
                .getPositiveRatings(
                        (int)Criterion.MIN_POSITIVE_RATINGS.getMin());
        List<MusicStatistic> musicStats = musicStatisticService.getAll();

        int nombreParticipations = getNombreParticipations(profilId);

        BadgeAssigner assigner = new BadgeAssigner(badgesExistants);

        if (assigner.shouldAssignCommentBadge(userComments)) {
            saveBadge(profilId, BadgeType.COMMENTAIRES);
        }

        if (assigner.shouldAssignPositiveRatingsBadge(positiveRatings)) {
            saveBadge(profilId, BadgeType.EVALUATIONS_POSITIVES);
        }

        if (assigner.shouldAssignMusicCompatibilityBadge(musicStats)) {
            saveBadge(profilId, BadgeType.COMPATIBILITE_MUSICALE);
        }

        if (assigner.shouldAssignParticipationBadge(nombreParticipations)) {
            saveBadge(profilId, BadgeType.PARTICIPATION);
        }
    }

    /**
     * Save badge.
     *
     * @param profilId  the profil id
     * @param badgeType the badge type
     */
    private void saveBadge(final String profilId, final BadgeType badgeType) {
        Badge badge = new Badge();
        badge.setProfilId(profilId);
        badge.setBadgeName(badgeType.getDisplayName());
        badgeRepository.save(badge);
    }

    /**
     * Gets nombre participations.
     *
     * @param profilId the profil id
     * @return the nombre participations
     */
    private int getNombreParticipations(final String profilId) {
        return eventService.countEventsByProfilId(profilId);
    }

    /**
     * Gets all badges.
     *
     * @return the all badges
     */
    public List<Badge> getAllBadges() {
        return badgeRepository.findAll();
    }

    /**
     * Gets badge by id.
     *
     * @param id the id
     * @return the badge by id
     */
    public Optional<Badge> getBadgeById(final String id) {
        return badgeRepository.findById(id);
    }

    /**
     * Gets badges by profil id.
     *
     * @param profilId the profil id
     * @return the badges by profil id
     */
    public List<Badge> getBadgesByProfilId(final String profilId) {
        return badgeRepository.findByProfilId(profilId);
    }

    //    public Badge createBadge(Badge badge) {
    //        return badgeRepository.save(badge);
    //    }

    /**
     * Delete badge.
     *
     * @param id the id
     */
    public void deleteBadge(final String id) {
        badgeRepository.deleteById(id);
    }
}
