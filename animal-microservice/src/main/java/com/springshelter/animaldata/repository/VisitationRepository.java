package com.springshelter.animaldata.repository;

import com.springshelter.animaldata.models.Visitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "animalShelter", path = "animalShelter")
public interface VisitationRepository extends JpaRepository<Visitation, UUID> {
}
