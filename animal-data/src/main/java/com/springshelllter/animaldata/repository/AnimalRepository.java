package com.springshelllter.animaldata.repository;

import com.springshelllter.animaldata.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "animalShelter", path = "animalShelter")
public interface AnimalRepository extends JpaRepository<Animal, UUID> {
}
