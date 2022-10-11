package com.afkl.travel.exercise.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;

import java.util.Base64;

public class TestData {
    public static final String BASE_URL = "http://localhost:8080/travel";
    public static final String GET_LOCATIONS_ENDPOINT = "/locations";
    public static final String GET_LOCATIONS_BY_CODE_AND_TYPE_ENDPOINT = "/locations/{type}/{code}";


    public static HttpEntity createRequestHttpEntity() {
        return new HttpEntity(createRequestHttpHeaders());
    }

    public static HttpHeaders createRequestHttpHeaders() {
        // create auth credentials
        String authStr = "someuser:psw";
        String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());

        // create headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Creds);
        return headers;
    }

}
