package com.afkl.travel.exercise.service;

import com.afkl.travel.exercise.controller.messages.AvailableLocations;

import java.util.List;

public interface LocationService {

    List<AvailableLocations> getLocations();

    AvailableLocations getLocationsByTypeAndCode(String type, String code);

}
