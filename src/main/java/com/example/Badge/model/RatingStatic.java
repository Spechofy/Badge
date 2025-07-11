package com.example.Badge.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type Rating static.
 */
@Document
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingStatic {
    /**
     * The Rating id.
     */
    private String ratingId;
    /**
     * The Comment.
     */
    private String comment;
    /**
     * The Rate.
     */
    private int rate;

}
