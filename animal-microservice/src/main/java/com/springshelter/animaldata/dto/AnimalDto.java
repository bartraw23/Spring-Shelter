package com.springshelter.animaldata.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class AnimalDto {
    private UUID id;

    private String name;

    private String species;

    private String race;

    private String gender;

    private Double weight;

    private LocalDate dateOfBirth;

    private LocalDateTime dateOfEnrollment;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDateTime getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDateTime dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
