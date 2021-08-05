package com.peregud.travelhistory;

import com.peregud.travelhistory.controller.JourneyController;
import com.peregud.travelhistory.repository.JourneyRepository;
import com.peregud.travelhistory.service.WeatherService;
import org.springframework.boot.test.mock.mockito.MockBean;

public class MockInit {

    @MockBean
    protected JourneyController journeyController;

    @MockBean
    protected JourneyRepository journeyRepository;

    @MockBean
    protected WeatherService weatherService;
}
