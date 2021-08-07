package travelhistorymvc.service.impl;

import com.peregud.travelhistorymvc.domain.Journey;
import com.peregud.travelhistorymvc.dto.JourneyDto;
import com.peregud.travelhistorymvc.service.ConvertService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import travelhistorymvc.MockInit;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ConvertServiceImplTest extends MockInit {

    @Autowired
    private ConvertService convertService;

    @Test
    void convertEntity() {
        Journey journey = new Journey();
        JourneyDto journeyDto = new JourneyDto();
        assertEquals(journeyDto, convertService.convertEntity(journey, JourneyDto.class));
    }
}
