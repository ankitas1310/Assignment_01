package com.afkl.travel.exercise.dao;

import com.afkl.travel.exercise.domain.Location;

import java.util.List;

public interface LocationDao {

    List<Location> getLocations();

    Location getLocationsByTypeAndCode(String type, String code);
}
