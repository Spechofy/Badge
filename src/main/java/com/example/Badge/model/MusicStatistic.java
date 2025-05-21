package com.example.Badge.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MusicStatistic {
    private double musicCompatibility;
    private double artistCompatibility;
    private double styleCompatibility;
}

