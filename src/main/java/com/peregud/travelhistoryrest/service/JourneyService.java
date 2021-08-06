package com.peregud.travelhistoryrest.service;

import com.peregud.travelhistoryrest.domain.Journey;
import com.peregud.travelhistoryrest.dto.JourneyDto;
import com.peregud.travelhistoryrest.payload.ApiResponse;
import com.peregud.travelhistoryrest.payload.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface JourneyService {

    PageResponse<JourneyDto> getAllJourneys(int page, int size);

    ResponseEntity<Journey> addJourney(Journey journey);

    ResponseEntity<JourneyDto> getJourney(Long id);

    ResponseEntity<Journey> updateJourney(Long id, Journey journey);

    ResponseEntity<ApiResponse> deleteJourney(Long id);

    String getCity(Long id);

    Journey getJourneyById(Long id);
}
