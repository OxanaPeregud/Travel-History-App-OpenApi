package com.peregud.travelhistorymvc.service.impl;

import com.peregud.travelhistorymvc.domain.Journey;
import com.peregud.travelhistorymvc.dto.JourneyDto;
import com.peregud.travelhistorymvc.repository.JourneyRepository;
import com.peregud.travelhistorymvc.service.ConvertService;
import com.peregud.travelhistorymvc.service.JourneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import static com.peregud.travelhistorymvc.AppConstants.PAGE_SIZE;
import static com.peregud.travelhistorymvc.AppConstants.PARAM_ID;

@Service
public class JourneyServiceImpl implements JourneyService {

    @Autowired
    private JourneyRepository journeyRepository;

    @Autowired
    private ConvertService convertService;

    @Override
    public Page<JourneyDto> getAll(String pageNo) {
        int gotoPageNo = Integer.parseInt(pageNo);
        Page<Journey> journeys = journeyRepository.findAll(gotoPage(gotoPageNo));
        return journeys.map(journey -> convertService.convertEntity(journey, JourneyDto.class));
    }

    @Override
    public String getCity(Long id) {
        return journeyRepository.getCity(id);
    }

    @Override
    public Journey getById(Long id) {
        return journeyRepository.getById(id);
    }

    @Override
    public void save(Journey journey) {
        journeyRepository.save(journey);
    }

    @Override
    public void update(Journey journey, Long id) {
        Journey journeyExisting = journeyRepository.getById(id);
        journey.setId(journeyExisting.getId());
        journeyRepository.save(journey);
    }

    @Override
    public void delete(String[] idList) {
        for (String id : idList) {
            journeyRepository.deleteById(Long.parseLong(id));
        }
    }

    private PageRequest gotoPage(int page) {
        return PageRequest.of(page, PAGE_SIZE, Sort.Direction.ASC, PARAM_ID);
    }
}
