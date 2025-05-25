package com.example.Badge.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Rating static.
 */
@Document
public class RatingStatic {
    private String ratingId;
    private String comment;
    private int rate;

    /**
     * Gets rating id.
     *
     * @return the rating id
     */
    public String getRatingId() {
        return ratingId;
    }

    /**
     * Sets rating id.
     *
     * @param ratingId the rating id
     */
    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    /**
     * Gets comment.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment the comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Gets rate.
     *
     * @return the rate
     */
    public int getRate() {
        return rate;
    }

    /**
     * Sets rate.
     *
     * @param rate the rate
     */
    public void setRate(int rate) {
        this.rate = rate;
    }
}

