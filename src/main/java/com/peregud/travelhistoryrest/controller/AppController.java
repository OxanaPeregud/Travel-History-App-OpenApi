package com.peregud.travelhistoryrest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import static com.peregud.travelhistoryrest.util.AppConstants.*;

@Controller
public class AppController {

    @RequestMapping(PAGE_START)
    public RedirectView homePage() {
        return new RedirectView(PAGE_JOURNEYS);
    }
}
