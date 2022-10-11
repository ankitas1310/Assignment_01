package com.afkl.travel.exercise.client;

import com.afkl.travel.exercise.config.TestConfiguration;
import com.afkl.travel.exercise.controller.messages.AvailableLocations;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.afkl.travel.exercise.client.TestData.BASE_URL;
import static com.afkl.travel.exercise.client.TestData.GET_LOCATIONS_BY_CODE_AND_TYPE_ENDPOINT;
import static com.afkl.travel.exercise.client.TestData.GET_LOCATIONS_ENDPOINT;
import static com.afkl.travel.exercise.client.TestData.createRequestHttpEntity;

@RunWith(SpringRunner.class)
@Import(TestConfiguration.class)
public class TravelWebClientTest {

    @Autowired
    private TravelWebClient webClient;


    @Test
    public void getLocationsTest() {
        //give
        final String url = BASE_URL + GET_LOCATIONS_ENDPOINT;
        HttpEntity request = createRequestHttpEntity();

        //when
        List<AvailableLocations> availableLocations = webClient.sendRequest(url, HttpMethod.GET, request, ArrayList.class);

        //then
        Assert.assertEquals(2234, availableLocations.size());
    }

    @Test
    public void getLocationsByTypeAndCodeTest() {
        //give
        Map<String, String> pathParams = new HashMap<String, String>();
        pathParams.put("type", "country");
        pathParams.put("code", "US");

        final String url = UriComponentsBuilder
                .fromUriString(BASE_URL + GET_LOCATIONS_BY_CODE_AND_TYPE_ENDPOINT)
                .buildAndExpand(pathParams)
                .toUriString();
        HttpEntity request = createRequestHttpEntity();

        //when
        AvailableLocations availableLocations = webClient.sendRequest(url, HttpMethod.GET, request, AvailableLocations.class);

        //then
        Assert.assertEquals("USA", availableLocations.getName());
        Assert.assertEquals("US", availableLocations.getCode());
        Assert.assertEquals("country", availableLocations.getType());
        Assert.assertEquals("-100.0", availableLocations.getLongitude());
        Assert.assertEquals("36.0", availableLocations.getLatitude());
        Assert.assertEquals("USA (US)", availableLocations.getDescription());
    }


}
