package com.afkl.travel.exercise.daoImpl;

import com.afkl.travel.exercise.dao.LocationDao;
import com.afkl.travel.exercise.domain.Location;
import com.afkl.travel.exercise.repository.LocationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LocationDaoImpl implements LocationDao {
    private static final Logger LOG = LoggerFactory.getLogger(LocationDaoImpl.class);

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public Location getLocationsByTypeAndCode(String type, String code) {
        LOG.trace("In getLocationsByTypeAndCode with type: {} and code: {}", type, code);

        return locationRepository.findAllByTypeAndCode(type, code);

    }

    @Override
    public List<Location> getLocations() {
        LOG.trace("In getLocations()");
        return locationRepository.findAll();
    }
}
