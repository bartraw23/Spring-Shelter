package com.springshelter.animaldata.service;

import com.springshelter.animaldata.dto.AnimalDto;
import com.springshelter.animaldata.models.Animal;
import com.springshelter.animaldata.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepository;

    @Transactional
    public Animal addAnimal(Animal animal) {
        animal.setDateOfEnrollment(LocalDateTime.now());
        return animalRepository.save(animal);
    }

    @Transactional
    public Optional<Animal> findById(UUID id) {
        return animalRepository.findById(id);
    }

    @Transactional
    public List<Animal> findByName(String name) {
        return animalRepository.findByName(name);
    }

    @Transactional
    public List<AnimalDto> findAll() {
        List<Animal> animalList = animalRepository.findAll();
        return animalList.stream().map(a -> entityToDto(a)).collect(Collectors.toList());
    }

    @Transactional
    public boolean delete(UUID id) {
        if (findById(id).isPresent()) {
            animalRepository.delete(findById(id).get());
            return true;
        }
        return false;
    }

    private AnimalDto entityToDto(Animal animal) {
        AnimalDto animalDto = new AnimalDto();
        animalDto.setId(animal.getId());
        animalDto.setName(animal.getName());
        animalDto.setSpecies(animal.getSpecies());
        animalDto.setRace(animal.getRace());
        animalDto.setDateOfBirth(animal.getDateOfBirth());
        animalDto.setDateOfEnrollment(animal.getDateOfEnrollment());
        animalDto.setGender(animal.getGender().toString());
        animalDto.setWeight(animal.getWeight());
        return animalDto;
    }
}
