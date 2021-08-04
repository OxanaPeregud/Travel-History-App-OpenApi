package com.peregud.travelhistory.service;

import com.peregud.travelhistory.domain.Journey;
import com.peregud.travelhistory.dto.JourneyDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface JourneyService {

    Page<JourneyDto> getAll(String pageNo);

    String getCity(Long id);

    Journey getById(Long id);

    void save(Journey journey);

    void update(Journey journey, Long id);

    void delete(String[] idList);
}
