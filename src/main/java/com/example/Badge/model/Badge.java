package com.example.Badge.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "badges")
public class Badge {

    @Id
    private String badgeId;
    private String badgeName;

    private String profilId; // référence vers Profil

    private RatingStatic ratingStatic;
    private CommentsStatic commentsStatic;
    private List<MusicStatistic> musicStatistics;

    public String getBadgeId() {
        return badgeId;
    }

    public void setBadgeId(String badgeId) {
        this.badgeId = badgeId;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public String getProfilId() {
        return profilId;
    }

    public void setProfilId(String profilId) {
        this.profilId = profilId;
    }

    public RatingStatic getRatingStatic() {
        return ratingStatic;
    }

    public void setRatingStatic(RatingStatic ratingStatic) {
        this.ratingStatic = ratingStatic;
    }

    public CommentsStatic getCommentsStatic() {
        return commentsStatic;
    }

    public void setCommentsStatic(CommentsStatic commentsStatic) {
        this.commentsStatic = commentsStatic;
    }

    public List<MusicStatistic> getMusicStatistics() {
        return musicStatistics;
    }

    public void setMusicStatistics(List<MusicStatistic> musicStatistics) {
        this.musicStatistics = musicStatistics;
    }
}

