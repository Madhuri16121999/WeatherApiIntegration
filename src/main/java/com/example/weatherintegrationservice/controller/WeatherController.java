package com.example.weatherintegrationservice.controller;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Value("${rapidapi.key}")
    private String apiKey;
	
	@Value("${weather.api.clientId}")
    private String clientId;

    @Value("${weather.api.clientSecret}")
    private String clientSecret;
	

	
	 @GetMapping("/forecastsummary")
	    public String getForecastSummary(@RequestParam String city) throws IOException {
		 
		 String url = "https://wettercom-wettercom-default.p.rapidapi.com/forecast9/location/" + city + "/summary";

         OkHttpClient client = new OkHttpClient();

         Request request = new Request.Builder()
                 .url(url)
                 .addHeader("X-RapidAPI-Key", apiKey)
                 .addHeader("X-RapidAPI-Proxy-Secret", clientSecret)
                 .addHeader("X-RapidAPI-Proxy-Client-Id", clientId)
                 .build();

         try (Response response = client.newCall(request).execute()) {
             return response.body().string();
         }
	    }

	    @GetMapping("/hourlyforecast")
	    public String getHourlyForecast(@RequestParam String city) throws IOException {
	    	
	    	String url = "https://wettercom-wettercom-default.p.rapidapi.com/forecast9/location/" + city + "/hourly";

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .addHeader("X-RapidAPI-Key", apiKey)
                    .addHeader("X-RapidAPI-Proxy-Secret", clientSecret)
                    .addHeader("X-RapidAPI-Proxy-Client-Id", clientId)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            }
	    }

}
