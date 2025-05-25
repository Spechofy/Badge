package com.example.Badge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The type Music statistic dto.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicStatisticDto {
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
