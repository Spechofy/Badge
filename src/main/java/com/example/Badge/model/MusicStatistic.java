package com.example.Badge.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Music statistic.
 */
@Document
@Getter
@Setter
public class MusicStatistic {
    private double musicCompatibility;
    private double artistCompatibility;
    private double styleCompatibility;

    /**
     * Gets music compatibility.
     *
     * @return the music compatibility
     */
    public double getMusicCompatibility() {
        return musicCompatibility;
    }

    /**
     * Sets music compatibility.
     *
     * @param musicCompatibility the music compatibility
     */
    public void setMusicCompatibility(double musicCompatibility) {
        this.musicCompatibility = musicCompatibility;
    }

    /**
     * Gets artist compatibility.
     *
     * @return the artist compatibility
     */
    public double getArtistCompatibility() {
        return artistCompatibility;
    }

    /**
     * Sets artist compatibility.
     *
     * @param artistCompatibility the artist compatibility
     */
    public void setArtistCompatibility(double artistCompatibility) {
        this.artistCompatibility = artistCompatibility;
    }

    /**
     * Gets style compatibility.
     *
     * @return the style compatibility
     */
    public double getStyleCompatibility() {
        return styleCompatibility;
    }

    /**
     * Sets style compatibility.
     *
     * @param styleCompatibility the style compatibility
     */
    public void setStyleCompatibility(double styleCompatibility) {
        this.styleCompatibility = styleCompatibility;
    }
}

