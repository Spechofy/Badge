package com.example.Badge.service.assignment;

public enum Criterion {
    MIN_PARTICIPATION_EVENT(5),
    MIN_POSITIVE_RATINGS(3),
    MIN_CONSTRUCTIVE_COMMENTS(4),
    MIN_MUSIC_COMPATIBILITY(0.8),
    MIN_RATE_COMMENTS(3.5);

    private final double min;

    Criterion(double min) {
        this.min = min;
    }

    public double getMin() {
        return min;
    }
}
