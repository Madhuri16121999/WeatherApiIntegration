package com.example.weatherintegrationservice.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WeatherConfig {
	@Value("${weather.api.clientId}")
    private String clientId;

    @Value("${weather.api.clientSecret}")
    private String clientSecret;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", clientSecret);
        headers.set("x-rapidapi-host", "wettercom-wettercom-default.p.rapidapi.com");
        headers.set("x-client-id", clientId);
        return headers;
    }
}

