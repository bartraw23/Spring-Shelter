package com.springshelter.viewmicroservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springshelter.viewmicroservice.models.Animals;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AnimalService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackAnimals",
            threadPoolKey = "animalPool",
            threadPoolProperties = {
                    @HystrixProperty(name = "coreSize", value = "20"),
                    @HystrixProperty(name = "maxQueueSize", value = "10")
            })
    public Animals getAnimalsList() {
        return restTemplate.getForObject("http://animal-data/", Animals.class);
    }

    private Animals getFallbackAnimals() {
        return new Animals();
    }
}
