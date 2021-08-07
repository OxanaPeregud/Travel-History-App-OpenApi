package com.peregud.travelhistoryrest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.peregud.travelhistoryrest.domain.CurrentWeather;
import com.peregud.travelhistoryrest.domain.Journey;
import com.peregud.travelhistoryrest.dto.JourneyDto;
import com.peregud.travelhistoryrest.repository.JourneyRepository;
import com.peregud.travelhistoryrest.service.JourneyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static com.peregud.travelhistoryrest.util.AppConstants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(JourneyRestController.class)
class JourneyRestControllerTest {

    @MockBean
    private JourneyRestController journeyRestController;

    @MockBean
    private JourneyRepository journeyRepository;

    @MockBean
    private JourneyService journeyService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        this.mockMvc.perform(get(PAGE_JOURNEYS)
                .param(PAGE, "1")
                .param(SIZE, "1")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    void addJourney() throws Exception {
        Journey journey = new Journey();
        this.mockMvc.perform(post(PAGE_JOURNEYS)
                .content(asJsonString(journey))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    void getJourney() throws Exception {
        JourneyDto journey = new JourneyDto();
        this.mockMvc.perform(get("/api/journeys/{id}", 1L)
                .content(asJsonString(journey))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    void updateJourney() throws Exception {
        Journey journey = new Journey();
        this.mockMvc.perform(put("/api/journeys/{id}", 1L)
                .content(asJsonString(journey))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    void deleteJourney() throws Exception {
        this.mockMvc.perform(delete("/api/journeys/{id}", 1L)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    void displayWeather() throws Exception {
        CurrentWeather currentWeather = new CurrentWeather();
        this.mockMvc.perform(get("/api/journeys/weather/{id}", 1L)
                .content(asJsonString(currentWeather))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    private static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
