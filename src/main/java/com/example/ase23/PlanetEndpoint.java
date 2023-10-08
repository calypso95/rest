package com.example.ase23;

import com.example.ase23.dto.PlanetDto;
import com.example.ase23.entity.Planet;
import com.example.ase23.exceptions.NotFoundException;
import com.example.ase23.exceptions.RequestFieldsException;
import com.example.ase23.service.IPlanetService;
import com.example.ase23.util.mapper.PlanetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/planets")
public class PlanetEndpoint {

    private final IPlanetService planetService;
    private final PlanetMapper planetMapper;

    @Autowired
    public PlanetEndpoint(IPlanetService planetService, PlanetMapper planetMapper) {
        this.planetService = planetService;
        this.planetMapper = planetMapper;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(code = HttpStatus.OK)
    public List<PlanetDto> getAll() {
        try {
            return planetMapper.planetListToDtoList(planetService.findAll());
        } catch (NotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(code = HttpStatus.OK)
    public PlanetDto createPlanet(@RequestBody PlanetDto planetDto) {
        Planet planet = planetMapper.DtoToEntity(planetDto);
        try {
            return planetMapper.entityToDto(planetService.createPlanet(planet));
        } catch (RequestFieldsException e) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
