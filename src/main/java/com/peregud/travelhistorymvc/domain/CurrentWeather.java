package com.peregud.travelhistorymvc.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CurrentWeather implements Serializable {
    private String description;
    private BigDecimal temperature;
    private BigDecimal feelsLike;
    private BigDecimal windSpeed;
}
