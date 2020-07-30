package com.springshelter.animaldata.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Visitation {
    @Id
    @GeneratedValue
    @JsonIgnore
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "animal_id")
    private Animal animal;

    @Email
    @NotEmpty
    @Column(nullable = false)
    private String visitorMail;

    @Column(nullable = false)
    private LocalDate date;

    public Visitation(String visitorMail, Animal animal, LocalDate date) {
        this.animal = animal;
        this.visitorMail = visitorMail;
        this.date = date;
    }

    public Visitation() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getVisitorMail() {
        return visitorMail;
    }

    public void setVisitorMail(String visitorMail) {
        this.visitorMail = visitorMail;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
