package com.peregud.travelhistoryrest.util;

public class AppConstants {
    public static final String PAGE_START = "/";
    public static final String PAGE_JOURNEYS = "/api/journeys";
    public static final String PAGE_ID = "/{id}";
    public static final String PAGE_WEATHER_ID = "/weather/{id}";

    public static final String PAGE = "page";
    public static final String SIZE = "size";
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "30";
    public static final Integer MAX_PAGE_SIZE = 30;

    public static final String WEATHER = "weather";
    public static final String WEATHER_MAIN = "main";
    public static final String WEATHER_TEMP = "temp";
    public static final String WEATHER_FEELS_LIKE = "feels_like";
    public static final String WEATHER_WIND = "wind";
    public static final String WEATHER_SPEED = "speed";

    public static final String ERROR_JSON = "Error parsing JSON";
    public static final String ERROR_NEGATIVE_PAGE = "Page number cannot be less than zero";
    public static final String ERROR_NEGATIVE_SIZE = "Size number cannot be less than zero";
    public static final String ERROR_OVERSIZE = "Page size must not be greater than ";

    public static final String JOURNEY_STR = "Journey";
    public static final String ID = "id";
    public static final String DELETE_SUCCESS = "You successfully deleted journey";
}
