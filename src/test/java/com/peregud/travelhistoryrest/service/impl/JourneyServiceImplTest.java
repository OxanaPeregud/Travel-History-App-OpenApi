package com.peregud.travelhistoryrest.service.impl;

import com.peregud.travelhistoryrest.domain.Journey;
import com.peregud.travelhistoryrest.dto.JourneyDto;
import com.peregud.travelhistoryrest.payload.ApiResponse;
import com.peregud.travelhistoryrest.repository.JourneyRepository;
import com.peregud.travelhistoryrest.service.JourneyService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static com.peregud.travelhistoryrest.util.AppConstants.ID;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@WebMvcTest(JourneyServiceImpl.class)
class JourneyServiceImplTest {

    @MockBean
    private JourneyService journeyService;

    @MockBean
    private JourneyRepository journeyRepository;

    @Test
    void getAllJourneys() {
        Pageable pageable = PageRequest.of(0, 2, Sort.Direction.ASC, ID);
        List<JourneyDto> list = new ArrayList<>();
        Page<JourneyDto> page = new PageImpl<>(list, pageable, 10);
        ResponseEntity<Page<JourneyDto>> responseEntity = new ResponseEntity<>(page, HttpStatus.OK);
        when(journeyService.getAllJourneys(any(Pageable.class))).thenReturn(responseEntity);
        assertEquals(responseEntity, journeyService.getAllJourneys(pageable));
    }

    @Test
    void addJourney() {
        Journey journey = new Journey();
        ResponseEntity<Journey> responseEntity = new ResponseEntity<>(journey, HttpStatus.CREATED);
        when(journeyService.addJourney(any(Journey.class))).thenReturn(responseEntity);
        assertEquals(responseEntity, journeyService.addJourney(journey));
    }

    @Test
    void getJourney() {
        JourneyDto journeyDto = new JourneyDto();
        ResponseEntity<JourneyDto> responseEntity = new ResponseEntity<>(journeyDto, HttpStatus.OK);
        when(journeyService.getJourney(any(Long.class))).thenReturn(responseEntity);
        assertEquals(responseEntity, journeyService.getJourney(1L));
    }

    @Test
    void updateJourney() {
        Journey journey = new Journey();
        ResponseEntity<Journey> responseEntity = new ResponseEntity<>(journey, HttpStatus.OK);
        when(journeyService.updateJourney(any(Long.class), any(Journey.class))).thenReturn(responseEntity);
        assertEquals(responseEntity, journeyService.updateJourney(1L, journey));
    }

    @Test
    void deleteJourney() {
        ApiResponse apiResponse = new ApiResponse();
        ResponseEntity<ApiResponse> responseEntity = new ResponseEntity<>(apiResponse, HttpStatus.OK);
        when(journeyService.deleteJourney(any(Long.class))).thenReturn(responseEntity);
        assertEquals(responseEntity, journeyService.deleteJourney(1L));
    }

    @Test
    void getCity() {
        JourneyDto journeyDto = JourneyDto.builder().id(1L).city("Minsk").build();
        when(journeyService.getCity(any(Long.class))).thenReturn(journeyDto.getCity());
        assertEquals("Minsk", journeyService.getCity(1L));
    }

    @Test
    void getJourneyById() {
        Journey journey = Journey.builder().id(1L).city("Minsk").build();
        when(journeyService.getJourneyById(any(Long.class))).thenReturn(journey);
        assertEquals(journey, journeyService.getJourneyById(1L));
    }
}
