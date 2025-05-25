package com.example.Badge.service;

import com.example.Badge.model.*;
import com.example.Badge.service.assignment.BadgeAssigner;
import com.example.Badge.service.assignment.BadgeType;
import com.example.Badge.repository.BadgeRepository;
import com.example.Badge.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * The type Badge service.
 */
@Service
public class BadgeService {

    @Autowired
    private BadgeRepository badgeRepository;

    @Autowired
    private ProfilRepository profilRepository;

    @Autowired
    private CommentsStaticService commentsStaticService;

    @Autowired
    private RatingStaticService ratingStaticService;

    @Autowired
    private MusicStatisticService musicStatisticService;

    @Autowired
    private EventService eventService;

    /**
     * Assign badges to profil.
     *
     * @param profilId the profil id
     */
    public void assignBadgesToProfil(String profilId) {
        Profil profil = profilRepository.findById(profilId)
                .orElseThrow(() -> new RuntimeException("Profil non trouvé"));
        String userId = profil.getUserId();

        List<Badge> badgesExistants = badgeRepository.findByProfilId(profilId);
        List<CommentsStatic> userComments = commentsStaticService.getCommentsByUserId(userId);
        List<RatingStatic> positiveRatings = ratingStaticService.getPositiveRatings(3);
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

    private void saveBadge(String profilId, BadgeType badgeType) {
        Badge badge = new Badge();
        badge.setProfilId(profilId);
        badge.setBadgeName(badgeType.getDisplayName());
        badgeRepository.save(badge);
    }

    private int getNombreParticipations(String profilId) {
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
    public Optional<Badge> getBadgeById(String id) {
        return badgeRepository.findById(id);
    }


    /**
     * Gets badges by profil id.
     *
     * @param profilId the profil id
     * @return the badges by profil id
     */
    public List<Badge> getBadgesByProfilId(String profilId) {
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
    public void deleteBadge(String id) {
        badgeRepository.deleteById(id);
    }
}
