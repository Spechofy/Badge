package com.example.Badge.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RatingStatic {
    private String ratingId;
    private String comment;
    private int rate;
}

