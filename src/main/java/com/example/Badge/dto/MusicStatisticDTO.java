package com.example.Badge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicStatisticDTO {
    private double musicCompatibility;
    private double artistCompatibility;
    private double styleCompatibility;
}
