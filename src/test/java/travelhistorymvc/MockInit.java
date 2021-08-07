package travelhistorymvc;

import com.peregud.travelhistorymvc.controller.JourneyController;
import com.peregud.travelhistorymvc.repository.JourneyRepository;
import com.peregud.travelhistorymvc.service.WeatherService;
import org.springframework.boot.test.mock.mockito.MockBean;

public class MockInit {

    @MockBean
    protected JourneyController journeyController;

    @MockBean
    protected JourneyRepository journeyRepository;

    @MockBean
    protected WeatherService weatherService;
}
