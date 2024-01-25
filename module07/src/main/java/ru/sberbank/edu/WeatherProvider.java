package ru.sberbank.edu;

import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;

public class WeatherProvider implements Serializable {

    //    private RestTemplate restTemplate = null;

    /**
     * Download ACTUAL weather info from internet.
     * You should call GET http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}
     * You should use Spring Rest Template for calling requests
     *
     * @param city - city
     * @return weather info or null
     */
    private RestTemplate restTemplate = new RestTemplate();

    public WeatherInfo get(String city) {
        String ApiKey = "";
        String URL = "http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=" + ApiKey;

        try {
            WeatherInfo weatherInfo = restTemplate.getForObject(URL, WeatherInfo.class);
            return weatherInfo;
        }
        catch (HttpClientErrorException ex) {
            return null;
        }
    }
}
