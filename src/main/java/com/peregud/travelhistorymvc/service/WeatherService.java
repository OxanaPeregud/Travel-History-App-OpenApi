package com.peregud.travelhistorymvc.service;

import com.peregud.travelhistorymvc.domain.CurrentWeather;

public interface WeatherService {

    CurrentWeather getCurrentWeather(String city);
}
