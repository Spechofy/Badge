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
    private double musicCompatibility;
    private double artistCompatibility;
    private double styleCompatibility;

}
