package com.example.Badge.service.assignment;

import com.example.Badge.model.Badge;
import com.example.Badge.model.CommentsStatic;
import com.example.Badge.model.MusicStatistic;
import com.example.Badge.model.RatingStatic;
import lombok.AllArgsConstructor;

import java.util.List;

import static com.example.Badge.service.assignment.BadgeType.*;
import static com.example.Badge.service.assignment.Criterion.*;

@AllArgsConstructor
public class BadgeAssigner {

    private final List<Badge> existingBadges;

    public boolean shouldAssignCommentBadge(List<CommentsStatic> comments) {
        long constructiveCount = comments.stream()
                .filter(c -> c.getRate() >= MIN_RATE_COMMENTS.getMin())
                .count();

        return constructiveCount >= MIN_CONSTRUCTIVE_COMMENTS.getMin() && !hasBadge(COMMENTAIRES.getDisplayName());
    }

    public boolean shouldAssignPositiveRatingsBadge(List<RatingStatic> ratings) {
        return ratings.size() >= MIN_POSITIVE_RATINGS.getMin() && !hasBadge(EVALUATIONS_POSITIVES.getDisplayName());
    }

    public boolean shouldAssignMusicCompatibilityBadge(List<MusicStatistic> stats) {
        double average = stats.stream()
                .mapToDouble(MusicStatistic::getMusicCompatibility)
                .average()
                .orElse(0.0);

        return average >= MIN_MUSIC_COMPATIBILITY.getMin() && !hasBadge(COMPATIBILITE_MUSICALE.getDisplayName());
    }

    public boolean shouldAssignParticipationBadge(int participationCount) {
        return participationCount >= MIN_PARTICIPATION_EVENT.getMin() && !hasBadge(PARTICIPATION.getDisplayName());
    }

    private boolean hasBadge(String badgeName) {
        return existingBadges.stream()
                .anyMatch(b -> b.getBadgeName().equalsIgnoreCase(badgeName));
    }
}
