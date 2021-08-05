package com.peregud.travelhistory.service.impl;

import com.peregud.travelhistory.domain.Journey;
import com.peregud.travelhistory.repository.JourneyRepository;
import com.peregud.travelhistory.service.JourneyService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JourneyServiceImplTest {

    @Autowired
    private JourneyService journeyService;

    @Autowired
    private JourneyRepository journeyRepository;

    private Journey journey;

    @BeforeEach
    public void setUp() {
        journey = Journey.builder()
                .city("Minsk")
                .build();
        journeyRepository.save(journey);
    }

    @AfterEach
    public void cleanUp() {
        journeyRepository.deleteAll();
        journeyRepository.flush();
    }

    @Test
    void getCity() {
        assertEquals("Minsk", journeyService.getCity(journey.getId()));
    }

    @Test
    void getById() {
        assertNotNull(journeyService.getById(journey.getId()));
    }

    @Test
    void save() {
        Journey journey1 = Journey.builder()
                .city("Moscow")
                .build();
        journeyService.save(journey1);
        assertEquals("Moscow", journeyService.getCity(journey1.getId()));
    }

    @Test
    void update() {
        journeyService.update(journey, 2L);
        assertEquals("Minsk", journeyService.getCity(2L));
    }

    @Test
    void delete() {
        journeyService.delete(new String[]{String.valueOf(journey.getId())});
        assertNull(journeyService.getCity(journey.getId()));
    }
}
