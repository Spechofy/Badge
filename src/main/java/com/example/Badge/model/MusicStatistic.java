package com.example.Badge.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Music statistic.
 */
@Document
@Builder
@Data
public class MusicStatistic {
    /**
     * The Music compatibility.
     */
    private double musicCompatibility;
    /**
     * The Artist compatibility.
     */
    private double artistCompatibility;
    /**
     * The Style compatibility.
     */
    private double styleCompatibility;

}
