package com.peregud.travelhistory.controller;

import com.peregud.travelhistory.repository.JourneyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.peregud.travelhistory.AppConstants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(JourneyController.class)
class JourneyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JourneyController journeyController;

    @MockBean
    private JourneyRepository journeyRepository;

    @Test
    void displayJourneys() throws Exception {
        this.mockMvc.perform(get(PAGE_JOURNEYS_LIST)
                .param(PARAM_PAGE_NUMBER, "1"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("journeys/list"))
                .andReturn();
    }

    @Test
    void insertJourney() throws Exception {
        this.mockMvc.perform(post(PAGE_JOURNEY_INSERT)
                .param(PARAM_ID, "1")
                .param(PARAM_COUNTRY, "1")
                .param(PARAM_CITY, "1")
                .param(PARAM_YEAR, "1")
                .param(PARAM_DESCRIPTION, "1")
                .param(PARAM_USER, "1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void editJourney() throws Exception {
        this.mockMvc.perform(get(PAGE_JOURNEY_EDIT)
                .param(PARAM_ID, "1"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("journeys/edit"))
                .andReturn();
    }

    @Test
    void updateJourney() throws Exception {
        this.mockMvc.perform(post(PAGE_JOURNEY_UPDATE)
                .param(PARAM_ID, "1")
                .param(PARAM_COUNTRY, "1")
                .param(PARAM_CITY, "1")
                .param(PARAM_YEAR, "1")
                .param(PARAM_DESCRIPTION, "1")
                .param(PARAM_USER, "1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void deleteJourneys() throws Exception {
        this.mockMvc.perform(post(PAGE_JOURNEYS_DELETE)
                .param(PARAM_DELETE_JOURNEY, "1"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    void displayWeather() throws Exception {
        this.mockMvc.perform(get(PAGE_JOURNEYS_WEATHER)
                .param(PARAM_ID, "1"))
                .andExpect(status().isOk())
                .andExpect(forwardedUrl("journeys/weather"))
                .andReturn();
    }
}