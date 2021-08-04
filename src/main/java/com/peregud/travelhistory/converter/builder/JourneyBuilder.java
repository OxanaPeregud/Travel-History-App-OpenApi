package com.peregud.travelhistory.converter.builder;

import com.peregud.travelhistory.domain.Journey;

import java.util.Optional;

public class JourneyBuilder {

    public static Journey insertJourney(Long id, String country, String city, String currentWeather, Integer year,
                                        String description, String user) {
        Journey.JourneyBuilder builder = Journey.builder();
        Optional.ofNullable(id)
                .ifPresent(builder::id);
        return Journey.builder()
                .country(country)
                .city(city)
                .currentWeather(currentWeather)
                .year(year)
                .description(description)
                .user(user)
                .build();
    }
}
