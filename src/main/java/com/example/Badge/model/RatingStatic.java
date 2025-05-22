package com.example.Badge.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RatingStatic {
    private String ratingId;
    private String comment;
    private int rate;

    public String getRatingId() {
        return ratingId;
    }

    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}

