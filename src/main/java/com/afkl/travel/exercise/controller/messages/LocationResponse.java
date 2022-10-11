package com.afkl.travel.exercise.controller.messages;

import java.util.List;

public class LocationResponse {

    private List<AvailableLocations> availableLocations;

    public List<AvailableLocations> getAvailableLocations() {
        return availableLocations;
    }

    public void setAvailableLocations(List<AvailableLocations> availableLocations) {
        this.availableLocations = availableLocations;
    }
}
