package com.springshelter.animaldata.repository;

import com.springshelter.animaldata.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "animalShelter", path = "animalShelter")
public interface AnimalRepository extends JpaRepository<Animal, UUID> {
    List<Animal> findByName(String name);
    List<Animal> findByRace(String race);
    List<Animal> findBySpecies(String species);
    List<Animal> findByDateOfBirthAfter(LocalDateTime date);
    List<Animal> findByDateOfBirthBefore(LocalDateTime date);
    List<Animal> findByDateOfBirthBetween(LocalDateTime date1, LocalDateTime date2);
}
