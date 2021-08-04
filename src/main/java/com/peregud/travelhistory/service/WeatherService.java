package com.peregud.travelhistory.service;

import com.peregud.travelhistory.domain.CurrentWeather;

public interface WeatherService {

    CurrentWeather getCurrentWeather(String city);
}
