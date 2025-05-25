package com.example.Badge.kafka;

/**
 * The type Topics.
 */
<<<<<<< HEAD
public class Topics {
=======
public final  class Topics {
>>>>>>> 431feb1 (Check style code)
    private Topics() {
        // Empêche l'instanciation
        throw new UnsupportedOperationException("Utility class");
    }

    /**
     * The constant PROFILE.
     */
    public static final String PROFILE = "topic-profilEvents";

    /**
     * The constant COMMENT.
     */
    public static final String COMMENT = "topic-commentEvents";

    /**
     * The constant RATING.
     */
    public static final String RATING = "topic-ratingEvents";

    /**
     * The constant MUSIC.
     */
    public static final String MUSIC = "topic-musicEvents";

    /**
     * The constant EVENT.
     */
    public static final String EVENT = "topic-Events";
}
