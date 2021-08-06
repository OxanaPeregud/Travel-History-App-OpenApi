package com.peregud.travelhistoryrest.service;

import com.peregud.travelhistoryrest.domain.Journey;
import com.peregud.travelhistoryrest.dto.JourneyDto;
import com.peregud.travelhistoryrest.payload.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface JourneyService {

    ResponseEntity<Page<JourneyDto>> getAllJourneys(Pageable pageable);

    ResponseEntity<Journey> addJourney(Journey journey);

    ResponseEntity<JourneyDto> getJourney(Long id);

    ResponseEntity<Journey> updateJourney(Long id, Journey journey);

    ResponseEntity<ApiResponse> deleteJourney(Long id);

    String getCity(Long id);

    Journey getJourneyById(Long id);
}
