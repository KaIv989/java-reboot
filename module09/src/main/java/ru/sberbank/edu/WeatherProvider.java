package ru.sberbank.edu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
@Service
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
    private RestTemplate restTemplate;
    @Value("${app.apikey}")
    private String apiKey;
    @Value("${app.apiurl}")
    private String apiUrl;

    @Autowired
    public WeatherProvider(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public WeatherInfo get(String city) {

        try {
            WeatherInfo weatherInfo = restTemplate.getForObject(apiUrl, WeatherInfo.class, city, apiKey);
            return weatherInfo;
        }
        catch (HttpClientErrorException ex) {
            return null;
        }
    }
}
