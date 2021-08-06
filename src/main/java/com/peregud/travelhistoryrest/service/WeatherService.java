package com.peregud.travelhistoryrest.service;

import com.peregud.travelhistoryrest.domain.CurrentWeather;
import org.springframework.http.ResponseEntity;

public interface WeatherService {

    ResponseEntity<CurrentWeather> getCurrentWeather(String city);
}
