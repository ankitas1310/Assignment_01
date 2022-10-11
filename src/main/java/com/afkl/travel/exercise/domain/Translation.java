package com.afkl.travel.exercise.domain;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Translation")
public class Translation {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    private String language;
    @NotNull
    private String name;
    @NotNull
    private String description;

    @ManyToOne()
    @JoinColumn(name = "location", referencedColumnName = "id")
    @NotNull
    private Location location;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Translation{" +
                "id=" + id +
                ", language='" + language + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", location=" + location +
                '}';
    }

}
