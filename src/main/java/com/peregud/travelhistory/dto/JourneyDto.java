package com.peregud.travelhistory.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JourneyDto {
    private Long id;
    private String country;
    private String currentWeather;
    private Integer year;
    private String description;
    private String user;
}
