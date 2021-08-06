package com.peregud.travelhistoryrest.service.impl;

import com.peregud.travelhistoryrest.domain.Journey;
import com.peregud.travelhistoryrest.dto.JourneyDto;
import com.peregud.travelhistoryrest.exception.ResourceNotFoundException;
import com.peregud.travelhistoryrest.payload.ApiResponse;
import com.peregud.travelhistoryrest.payload.PageResponse;
import com.peregud.travelhistoryrest.repository.JourneyRepository;
import com.peregud.travelhistoryrest.service.ConvertService;
import com.peregud.travelhistoryrest.service.JourneyService;
import com.peregud.travelhistoryrest.util.AppUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.peregud.travelhistoryrest.util.AppConstants.*;

@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    @Autowired
    private ConvertService convertService;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PageResponse<JourneyDto> getAllJourneys(int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC);
        Page<Journey> journeys = journeyRepository.findAll(pageable);
        if (journeys.getNumberOfElements() == 0) {
            return new PageResponse<>(Collections.emptyList(), journeys.getNumber(), journeys.getSize(),
                    journeys.getTotalElements(), journeys.getTotalPages(), journeys.isLast());
        }
        List<JourneyDto> journeyList = Arrays.asList(modelMapper.map(journeys.getContent(), JourneyDto[].class));
        return new PageResponse<>(journeyList, journeys.getNumber(), journeys.getSize(),
                journeys.getTotalElements(), journeys.getTotalPages(), journeys.isLast());
    }

    @Override
    public ResponseEntity<Journey> addJourney(Journey journey) {
        Journey newJourney = journeyRepository.save(journey);
        return new ResponseEntity<>(newJourney, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<JourneyDto> getJourney(Long id) {
        Journey journey = journeyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(JOURNEY_STR, ID, id));
        JourneyDto journeyDto = convertService.convertEntity(journey, JourneyDto.class);
        return new ResponseEntity<>(journeyDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Journey> updateJourney(Long id, Journey newJourney) {
        Journey journey = journeyRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException(JOURNEY_STR, ID, id));
        journey.setId(newJourney.getId());
        return new ResponseEntity<>(journey, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResponse> deleteJourney(Long id) {
        journeyRepository.deleteById(id);
        return new ResponseEntity<>(new ApiResponse(
                Boolean.TRUE, "You successfully deleted journey"), HttpStatus.OK);
    }

    @Override
    public String getCity(Long id) {
        journeyRepository.getCity(id);
        return journeyRepository.getCity(id);
    }

    @Override
    public Journey getJourneyById(Long id) {
        return journeyRepository.getById(id);
    }
}
