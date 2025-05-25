package com.example.Badge.service.assignment;

import static com.example.Badge.service.assignment.BadgeType.*;
import static com.example.Badge.service.assignment.Criterion.*;

import com.example.Badge.model.Badge;
import com.example.Badge.model.CommentsStatic;
import com.example.Badge.model.MusicStatistic;
import com.example.Badge.model.RatingStatic;

import java.util.List;

import lombok.AllArgsConstructor;

/**
 * The type Badge assigner.
 */
@AllArgsConstructor
public class BadgeAssigner {

    /**
     * The Existing badges.
     */
    private final List<Badge> existingBadges;

    /**
     * Should assign comment badge boolean.
     *
     * @param comments the comments
     * @return the boolean
     */
    public boolean shouldAssignCommentBadge(final List<CommentsStatic> comments) {
        long constructiveCount =
                comments.stream().filter(c -> c.getRate() >= MIN_RATE_COMMENTS.getMin()).count();

        return constructiveCount >= MIN_CONSTRUCTIVE_COMMENTS.getMin()
                && !hasBadge(COMMENTAIRES.getDisplayName());
    }

    /**
     * Should assign positive ratings badge boolean.
     *
     * @param ratings the ratings
     * @return the boolean
     */
    public boolean shouldAssignPositiveRatingsBadge(final List<RatingStatic> ratings) {
        return ratings.size() >= MIN_POSITIVE_RATINGS.getMin()
                && !hasBadge(EVALUATIONS_POSITIVES.getDisplayName());
    }

    /**
     * Should assign music compatibility badge boolean.
     *
     * @param stats the stats
     * @return the boolean
     */
    public boolean shouldAssignMusicCompatibilityBadge(final List<MusicStatistic> stats) {
        double average =
                stats.stream().mapToDouble(
                        MusicStatistic::getMusicCompatibility).average().orElse(0.0);

        return average >= MIN_MUSIC_COMPATIBILITY.getMin()
                && !hasBadge(COMPATIBILITE_MUSICALE.getDisplayName());
    }

    /**
     * Should assign participation badge boolean.
     *
     * @param participationCount the participation count
     * @return the boolean
     */
    public boolean shouldAssignParticipationBadge(final int participationCount) {
        return participationCount >= MIN_PARTICIPATION_EVENT.getMin()
                && !hasBadge(PARTICIPATION.getDisplayName());
    }

    /**
     * Has badge boolean.
     *
     * @param badgeName the badge name
     * @return the boolean
     */
    private boolean hasBadge(final String badgeName) {
        return existingBadges.stream().anyMatch(b -> b.getBadgeName().equalsIgnoreCase(badgeName));
    }
}
