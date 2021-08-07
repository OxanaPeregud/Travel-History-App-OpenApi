package com.peregud.travelhistorymvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.peregud.travelhistorymvc.AppConstants.PAGE_START;
import static com.peregud.travelhistorymvc.AppConstants.VIEW_JOURNEYS_LIST;

@Controller
public class AppController {

    @RequestMapping(PAGE_START)
    public String staticResource() {
        return VIEW_JOURNEYS_LIST;
    }
}
