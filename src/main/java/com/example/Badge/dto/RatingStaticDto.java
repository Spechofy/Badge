package com.example.Badge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Rating static dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatingStaticDto {
    private String ratingId;
    private String comment;
    private int rate;
}
