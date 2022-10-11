package com.afkl.travel.exercise.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TravelWebClient {

    @Autowired
    private RestTemplate restTemplate;

    public <R> R sendRequest(String url, Class<R> responseType) {
        return restTemplate.getForObject(url, responseType);
    }

    public <R> R sendRequest(String url, HttpMethod httpMethod, HttpEntity request, Class<R> responseType) {
        ResponseEntity<R> response = restTemplate.exchange(url, httpMethod, request, responseType);

        return response.getBody();
    }
}
