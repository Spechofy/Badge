package com.example.Badge.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Getter
@Setter
public class MusicStatistic {
    private double musicCompatibility;
    private double artistCompatibility;
    private double styleCompatibility;

    public double getMusicCompatibility() {
        return musicCompatibility;
    }

    public void setMusicCompatibility(double musicCompatibility) {
        this.musicCompatibility = musicCompatibility;
    }

    public double getArtistCompatibility() {
        return artistCompatibility;
    }

    public void setArtistCompatibility(double artistCompatibility) {
        this.artistCompatibility = artistCompatibility;
    }

    public double getStyleCompatibility() {
        return styleCompatibility;
    }

    public void setStyleCompatibility(double styleCompatibility) {
        this.styleCompatibility = styleCompatibility;
    }
}

