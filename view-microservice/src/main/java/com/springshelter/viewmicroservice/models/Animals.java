package com.springshelter.viewmicroservice.models;

import java.util.ArrayList;
import java.util.List;

public class Animals {
    private List<Animal> animals;

    public Animals() {
        this.setAnimals(new ArrayList<>());
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
