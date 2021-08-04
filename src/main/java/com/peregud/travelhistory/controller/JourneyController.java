package com.peregud.travelhistory.controller;

import com.peregud.travelhistory.converter.builder.JourneyBuilder;
import com.peregud.travelhistory.domain.Journey;
import com.peregud.travelhistory.dto.JourneyDto;
import com.peregud.travelhistory.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static com.peregud.travelhistory.AppConstants.*;

@Controller
public class JourneyController {

    @Autowired
    private JourneyService journeyService;

    @GetMapping(PAGE_JOURNEYS_LIST)
    public String displayJourneys(Model model,
                                  @RequestParam(value = PARAM_PAGE_NUMBER, required = false,
                                          defaultValue = PAGE_NUMBER_DEFAULT)
                                          String pageNo) {
        Page<JourneyDto> page = journeyService.getAll(pageNo);
        List<JourneyDto> listJourneys = page.getContent();
        long totalJourneysCount = page.getTotalElements();
        int lastPageNo;
        if (totalJourneysCount % PAGE_SIZE != 0) {
            lastPageNo = (int) (totalJourneysCount / PAGE_SIZE) + 1;
        } else {
            lastPageNo = (int) (totalJourneysCount / PAGE_SIZE);
        }
        model.addAttribute(ATTR_LAST_PAGE, lastPageNo);
        model.addAttribute(ATTR_LIST_JOURNEYS, listJourneys);
        return VIEW_JOURNEYS_LIST;
    }

    @PostMapping(PAGE_JOURNEY_INSERT)
    public ModelAndView insertJourney(@RequestParam(required = false, value = PARAM_ID) Long id,
                                      @RequestParam(PARAM_COUNTRY) String country,
                                      @RequestParam(value = PARAM_CURRENT_WEATHER, required = false)
                                              String currentWeather,
                                      @RequestParam(value = PARAM_YEAR, required = false) Integer year,
                                      @RequestParam(PARAM_DESCRIPTION) String description,
                                      @RequestParam(PARAM_USER) String user,
                                      ModelMap model) {
        Journey journey = JourneyBuilder.insertJourney(id, country, currentWeather, year, description, user);
        journeyService.save(journey);
        return new ModelAndView(REDIRECT_JOURNEYS_LIST, model);
    }

    @GetMapping(PAGE_JOURNEY_EDIT)
    public String editJourney(@RequestParam(PARAM_ID) Long id, Model model) {
        Journey journey = journeyService.getById(id);
        model.addAttribute(ATTR_JOURNEY, journey);
        return VIEW_JOURNEY_FORM;
    }

    @PostMapping(PAGE_JOURNEY_UPDATE)
    public ModelAndView updateJourney(@RequestParam(PARAM_ID) Long id,
                                      @RequestParam(PARAM_COUNTRY) String country,
                                      @RequestParam(value = PARAM_CURRENT_WEATHER, required = false)
                                              String currentWeather,
                                      @RequestParam(value = PARAM_YEAR, required = false) Integer year,
                                      @RequestParam(PARAM_DESCRIPTION) String description,
                                      @RequestParam(PARAM_USER) String user,
                                      ModelMap model) {
        Journey journey = JourneyBuilder.insertJourney(id, country, currentWeather, year, description, user);
        journeyService.update(journey, id);
        return new ModelAndView(REDIRECT_JOURNEYS_LIST, model);
    }

    @PostMapping(PAGE_JOURNEYS_DELETE)
    public ModelAndView deleteJourneys(@RequestParam(PARAM_DELETE_JOURNEY) String[] idList, ModelMap model) {
        journeyService.delete(idList);
        return new ModelAndView(REDIRECT_JOURNEYS_LIST, model);
    }
}
