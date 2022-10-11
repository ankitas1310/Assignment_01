package com.afkl.travel.exercise.controller;

import com.afkl.travel.exercise.controller.messages.AvailableLocations;
import com.afkl.travel.exercise.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/travel")
public class LocationController {

    private static final String GET_LOCATIONS_ENDPOINT = "/locations";
    private static final String GET_LOCATIONS_BY_CODE_AND_TYPE_ENDPOINT = "/locations/{type}/{code}";

    private static final Logger LOG = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;


    @RequestMapping(method = GET,
            value = GET_LOCATIONS_ENDPOINT,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<AvailableLocations> getLocations() {
        LOG.trace("In getLocations()");
        //process request
        return locationService.getLocations();
    }


    @RequestMapping(method = GET,
            value = GET_LOCATIONS_BY_CODE_AND_TYPE_ENDPOINT,
            produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public AvailableLocations getLocationsByTypeAndCode(@PathVariable String type, @PathVariable String code) {
        LOG.trace("In getLocationsByTypeAndCode with type: {} and code: {}", type, code);
        //process request
        return locationService.getLocationsByTypeAndCode(type, code);
    }


}