package com.example.ase23.dto;

import org.springframework.stereotype.Component;

@Component
public class PlanetDto {

    private long id;
    private String name;

    public PlanetDto() {}

    public PlanetDto(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
