package com.example.ase23.util.mapper;

import com.example.ase23.dto.PlanetDto;
import com.example.ase23.entity.Planet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanetMapper {

    public PlanetDto entityToDto(Planet planet) {
        return new PlanetDto(planet.getId(), planet.getName());
    }

    public Planet DtoToEntity(PlanetDto planetDto) {
        return new Planet(planetDto.getId(), planetDto.getName());
    }

    public List<PlanetDto> planetListToDtoList(List<Planet> planetList){
        List<PlanetDto> planetDtoList = new ArrayList<>();
        for (Planet p: planetList) {
            planetDtoList.add(this.entityToDto(p));
        }
        return planetDtoList;
    }

}
