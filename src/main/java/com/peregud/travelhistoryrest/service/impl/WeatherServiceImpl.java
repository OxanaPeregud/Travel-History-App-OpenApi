package com.peregud.travelhistoryrest.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.peregud.travelhistoryrest.domain.CurrentWeather;
import com.peregud.travelhistoryrest.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplate;

import java.math.BigDecimal;
import java.net.URI;

import static com.peregud.travelhistoryrest.util.AppConstants.*;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Value("${apiKey}")
    private String apiKey;

    @Value("${weatherURL}")
    private String weatherUrl;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public ResponseEntity<CurrentWeather> getCurrentWeather(String city) {
        URI url = new UriTemplate(weatherUrl).expand(city, apiKey);
        ResponseEntity<String> response;
        try {
            response = restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            return null;
        }
        return new ResponseEntity<>(convert(response), HttpStatus.OK);
    }

    private CurrentWeather convert(ResponseEntity<String> response) {
        try {
            JsonNode root = objectMapper.readTree(response.getBody());
            return new CurrentWeather(root.path(WEATHER).get(0).path(WEATHER_MAIN).asText(),
                    BigDecimal.valueOf(root.path(WEATHER_MAIN).path(WEATHER_TEMP).asDouble()),
                    BigDecimal.valueOf(root.path(WEATHER_MAIN).path(WEATHER_FEELS_LIKE).asDouble()),
                    BigDecimal.valueOf(root.path(WEATHER_WIND).path(WEATHER_SPEED).asDouble()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(ERROR_JSON, e);
        }
    }
}
