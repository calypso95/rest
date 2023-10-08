package com.example.ase23.service;

import com.example.ase23.entity.Planet;
import com.example.ase23.exceptions.NotFoundException;
import com.example.ase23.exceptions.RequestFieldsException;

import java.util.List;

public interface IPlanetService {

    List<Planet> findAll() throws NotFoundException;

    Planet createPlanet(Planet planet) throws RequestFieldsException;

}
