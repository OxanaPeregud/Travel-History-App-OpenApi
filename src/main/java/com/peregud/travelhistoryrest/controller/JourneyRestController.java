package com.peregud.travelhistoryrest.controller;

import com.peregud.travelhistoryrest.domain.CurrentWeather;
import com.peregud.travelhistoryrest.domain.Journey;
import com.peregud.travelhistoryrest.dto.JourneyDto;
import com.peregud.travelhistoryrest.payload.ApiResponse;
import com.peregud.travelhistoryrest.service.JourneyService;
import com.peregud.travelhistoryrest.service.WeatherService;
import com.peregud.travelhistoryrest.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.peregud.travelhistoryrest.util.AppConstants.*;

@RestController
@RequestMapping(PAGE_JOURNEYS)
public class JourneyRestController {

    @Autowired
    private JourneyService journeyService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping
    public ResponseEntity<Page<JourneyDto>> getAll(
            @RequestParam(name = PAGE, required = false, defaultValue = DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(name = SIZE, required = false, defaultValue = DEFAULT_PAGE_SIZE) Integer size) {
        PageUtil.validatePageNumberAndSize(page, size);
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.ASC, ID);
        return journeyService.getAllJourneys(pageable);
    }

    @PostMapping
    public ResponseEntity<Journey> addJourney(@RequestBody Journey journey) {
        return journeyService.addJourney(journey);
    }

    @GetMapping(PAGE_ID)
    public ResponseEntity<JourneyDto> getJourney(@PathVariable(name = ID) Long id) {
        return journeyService.getJourney(id);
    }

    @PutMapping(PAGE_ID)
    public ResponseEntity<Journey> updateJourney(@PathVariable(name = ID) Long id, @RequestBody Journey newJourney) {
        return journeyService.updateJourney(id, newJourney);
    }

    @DeleteMapping(PAGE_ID)
    public ResponseEntity<ApiResponse> deleteJourney(@PathVariable(name = ID) Long id) {
        return journeyService.deleteJourney(id);
    }

    @GetMapping(PAGE_WEATHER_ID)
    public ResponseEntity<CurrentWeather> displayWeather(@PathVariable(name = ID) Long id) {
        Journey journey = journeyService.getJourneyById(id);
        return weatherService.getCurrentWeather(journeyService.getCity(journey.getId()));
    }
}
