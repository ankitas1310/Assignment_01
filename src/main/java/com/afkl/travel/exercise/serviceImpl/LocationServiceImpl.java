package com.afkl.travel.exercise.serviceImpl;

import com.afkl.travel.exercise.controller.messages.AvailableLocations;
import com.afkl.travel.exercise.dao.LocationDao;
import com.afkl.travel.exercise.domain.Location;
import com.afkl.travel.exercise.domain.Translation;
import com.afkl.travel.exercise.exceptions.TravelException;
import com.afkl.travel.exercise.service.LocationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    private static final Logger LOG = LoggerFactory.getLogger(LocationServiceImpl.class);

    @Autowired
    private LocationDao locationDao;

    @Override
    public List<AvailableLocations> getLocations() {
        LOG.trace("In getLocations()");

        List<Location> locations = locationDao.getLocations();
        return locations.stream().map(location -> mapLocation(location)).collect(Collectors.toList());

    }

    @Override
    public AvailableLocations getLocationsByTypeAndCode(String type, String code) {
        LOG.trace("In getLocationsByTypeAndCode with type: {} and code: {}", type, code);

        Location location = locationDao.getLocationsByTypeAndCode(type, code);
        return mapLocation(location);
    }

    private AvailableLocations mapLocation(Location location) {
        LOG.trace("In mapLocation with location: {}", location);
        if (location == null) {
            throw new TravelException("Location not found");
        }

        AvailableLocations availableLocation = new AvailableLocations();
        availableLocation.setCode(location.getCode());
        availableLocation.setType(location.getType());
        availableLocation.setLatitude(location.getLatitude());
        availableLocation.setLongitude(location.getLongitude());

        if (location.getParent_id() != null) {
            availableLocation.setParentCode(location.getParent_id().getCode());
            availableLocation.setParentType(location.getParent_id().getType());
        }

        List<Translation> translations = location.getTransalations();


        if (!translations.isEmpty()) {
            Translation translation = translations.get(0);
            availableLocation.setName(translation.getName());
            availableLocation.setDescription(translation.getDescription());
        }

        return availableLocation;
    }


}
