package com.afkl.travel.exercise.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue
    private Integer id;
    @NotNull
    private String code;
    @NotNull
    private String type;
    private Double longitude;
    private Double latitude;

    @ManyToOne()
    @JoinColumn(name = "parent_id", referencedColumnName = "id")
    private Location parent_id;


    @OneToMany(mappedBy = "location", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Translation> transalations;


    public List<Translation> getTransalations() {
        return transalations;
    }

    public void setTransalations(List<Translation> transalations) {
        this.transalations = transalations;
    }

    public Location getParent_id() {
        return parent_id;
    }

    public void setParent_id(Location parent_id) {
        this.parent_id = parent_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", parent_id=" + parent_id +
                '}';
    }

}
