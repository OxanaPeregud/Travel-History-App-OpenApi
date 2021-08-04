package com.peregud.travelhistory;

public class AppConstants {
    public static final String PARAM_ID = "id";
    public static final String PARAM_COUNTRY = "country";
    public static final String PARAM_CITY = "city";
    public static final String PARAM_YEAR = "year";
    public static final String PARAM_DESCRIPTION = "description";
    public static final String PARAM_USER = "user";
    public static final String PARAM_DELETE_JOURNEY = "delete";
    public static final String PARAM_PAGE_NUMBER = "pageNo";

    public static final String ATTR_LIST_JOURNEYS = "listJourneys";
    public static final String ATTR_JOURNEY = "journey";
    public static final String ATTR_LAST_PAGE = "lastPageNo";
    public static final String ATTR_CURRENT_WEATHER = "currentWeather";

    public static final String PAGE_START = "/";
    public static final String PAGE_JOURNEYS_LIST = "/journeys/list";
    public static final String PAGE_JOURNEY_FORM = "/journeys/add";
    public static final String PAGE_JOURNEY_INSERT = "/journeys/insert";
    public static final String PAGE_JOURNEY_EDIT = "/journeys/edit";
    public static final String PAGE_JOURNEY_UPDATE = "/journeys/update";
    public static final String PAGE_JOURNEYS_DELETE = "/journeys/delete";
    public static final String PAGE_JOURNEYS_WEATHER = "/journeys/weather";

    public static final String VIEW_JOURNEYS_LIST = "journeys-list";
    public static final String VIEW_JOURNEY_FORM = "journey-form";
    public static final String VIEW_CURRENT_WEATHER = "current-weather";

    public static final String REDIRECT_JOURNEYS_LIST = "redirect:/journeys/list";

    public static final Integer PAGE_SIZE = 4;
    public static final String PAGE_NUMBER_DEFAULT = "0";

    public static final String WEATHER_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&APPID={key}";
    public static final String WEATHER = "weather";
    public static final String WEATHER_MAIN = "main";
    public static final String WEATHER_TEMP = "temp";
    public static final String WEATHER_FEELS_LIKE = "feels_like";
    public static final String WEATHER_WIND = "wind";
    public static final String WEATHER_SPEED = "speed";

    public static final String ERROR_JSON = "Error parsing JSON";
}
