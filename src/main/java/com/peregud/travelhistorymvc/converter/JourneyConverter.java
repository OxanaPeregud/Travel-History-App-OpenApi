package com.peregud.travelhistorymvc.converter;

import com.peregud.travelhistorymvc.domain.Journey;
import com.peregud.travelhistorymvc.dto.JourneyDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class JourneyConverter implements Converter<Journey, JourneyDto> {

    @Override
    public JourneyDto convert(Journey journey) {
        JourneyDto.JourneyDtoBuilder builder = JourneyDto.builder();
        Optional.ofNullable(journey.getId())
                .ifPresent(builder::id);
        return builder
                .country(journey.getCountry())
                .city(journey.getCity())
                .year(journey.getYear())
                .description(journey.getDescription())
                .user(journey.getUser())
                .build();
    }
}
