package com.example.ase23.service;

import com.example.ase23.entity.Planet;
import com.example.ase23.entity.PlanetRepository;
import com.example.ase23.exceptions.NotFoundException;
import com.example.ase23.exceptions.RequestFieldsException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlanetService implements IPlanetService {

    private PlanetRepository planetRepository;

    public PlanetService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    @Override
    public List<Planet> findAll() throws NotFoundException {
        return this.planetRepository.findAll();
    }

    @Override
    public Planet createPlanet(Planet planet) throws RequestFieldsException {
        if (Objects.equals(planet.getName(), "")) {
            throw new RequestFieldsException("");
        }
        return this.planetRepository.save(planet);
    }

}
