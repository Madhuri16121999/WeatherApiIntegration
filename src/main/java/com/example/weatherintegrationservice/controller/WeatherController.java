package com.example.weatherintegrationservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/weather")
public class WeatherController {
	
	@Autowired
    private HttpHeaders headers;
	
	@Autowired
	private RestTemplate restTemplate;
	
	 @GetMapping("/forecastsummary")
	    public ResponseEntity<String> getForecastSummary(@RequestParam String city) {
	        String url = "https://wettercom-wettercom-default.p.rapidapi.com/forecast9/getForecastSummaryByLocationName";
	        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
	                .queryParam("q", city);

	        HttpEntity<?> entity = new HttpEntity<>(headers);

	        ResponseEntity<String> response = restTemplate.exchange(
	                builder.toUriString(),
	                HttpMethod.GET,
	                entity,
	                String.class
	        );

	        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	    }

	    @GetMapping("/hourlyforecast")
	    public ResponseEntity<String> getHourlyForecast(@RequestParam String city) {
	        String url = "https://wettercom-wettercom-default.p.rapidapi.com/forecast9/getHourlyForecastByLocationName";
	        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
	                .queryParam("q", city);

	        HttpEntity<?> entity = new HttpEntity<>(headers);

	        ResponseEntity<String> response = restTemplate.exchange(
	                builder.toUriString(),
	                HttpMethod.GET,
	                entity,
	                String.class
	        );

	        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
	    }

}
