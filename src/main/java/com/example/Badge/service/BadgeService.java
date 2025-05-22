package com.example.Badge.service;

import com.example.Badge.model.*;
import com.example.Badge.repository.BadgeRepository;
import com.example.Badge.repository.ProfilRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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



    public void assignBadgesToProfil(String profilId) {
        Profil profil = profilRepository.findById(profilId)
                .orElseThrow(() -> new RuntimeException("Profil non trouvé"));

        // Récupérer badges existants
        List<Badge> badgesExistants = badgeRepository.findByProfilId(profilId);

        String userId = profil.getUserId();

        // 1. Badge Commentaires constructifs
        List<CommentsStatic> userComments = commentsStaticService.getCommentsByUserId(userId);
        long nbCommentairesConstructifs = userComments.stream()
                .filter(c -> c.getRate() >= 4) // critères : commentaires avec note >= 4
                .count();
        if (nbCommentairesConstructifs >= 4 && !hasBadge(badgesExistants, "Badge Commentaires")) {
            saveNewBadge(profilId, "Badge Commentaires");
        }

        // 2. Badge Évaluations positives
        List<RatingStatic> positiveRatings = ratingStaticService.getPositiveRatings(3);
        long nbEvaluationsPositives = positiveRatings.stream()
                // à adapter : ici on ne filtre pas par userId, à modifier si besoin
                .count();
        if (nbEvaluationsPositives >= 3 && !hasBadge(badgesExistants, "Badge Évaluations Positives")) {
            saveNewBadge(profilId, "Badge Évaluations Positives");
        }

        // 3. Badge Compatibilité musicale
        List<MusicStatistic> stats = musicStatisticService.getAll();
        double avgCompat = stats.stream()
                .mapToDouble(MusicStatistic::getMusicCompatibility)
                .average()
                .orElse(0.0);
        if (avgCompat >= 0.8 && !hasBadge(badgesExistants, "Badge Compatibilité Musicale")) {
            saveNewBadge(profilId, "Badge Compatibilité Musicale");
        }

        // 4. Badge Participation événements (méthode à implémenter)
        int nombreParticipations = getNombreParticipations(profilId);
        if (nombreParticipations >= 5 && !hasBadge(badgesExistants, "Badge Participation")) {
            saveNewBadge(profilId, "Badge Participation");
        }
    }

    private boolean hasBadge(List<Badge> badges, String badgeName) {
        return badges.stream().anyMatch(b -> b.getBadgeName().equals(badgeName));
    }

    private void saveNewBadge(String profilId, String badgeName) {
        Badge badge = new Badge();
        badge.setProfilId(profilId);
        badge.setBadgeName(badgeName);
        badgeRepository.save(badge);
    }

    private int getNombreParticipations(String profilId) {

        return 6; // exemple statique
    }
}
