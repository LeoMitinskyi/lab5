package com.LeoMitinskyi.lab5.types;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
    public class Person {
        private long id;
        private String name;
        private Coordinates coordinates;
        @XmlElement(name = "creationDate")
        private String dateTimeString;
        @XmlTransient
        private LocalDate creationDate;
        private Integer height;
        private Color eyeColor;
        private Color hairColor;
        private Country nationality;
        private Location location;

        public Person(){}
        public Person(long id, String name, Coordinates coordinates, LocalDate creationDate, Integer height, Color eyeColor, Color hairColor, Country nationality, Location location){
            this.id = id;
            this.name = name;
            this.coordinates = coordinates;
            this.creationDate = creationDate;
            this.height = height;
            this.eyeColor = eyeColor;
            this.hairColor = hairColor;
            this.nationality = nationality;
            this.location = location;
        }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public LocalDate getCreationDate() {
        return LocalDate.now();
    }

    public Integer getHeight() {
        return height;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Color getHairColor() {
        return hairColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", coordinates=" + getCoordinates() +
                ", creationDate=" + getCreationDate() +
                ", height=" + getHeight() +
                ", eyeColor=" + getEyeColor() +
                ", hairColor=" + getHairColor() +
                ", nationality=" + getNationality() +
                ", location=" + getLocation() +
                '}' + '\n';
    }
}

