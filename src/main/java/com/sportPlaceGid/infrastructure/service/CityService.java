package com.sportPlaceGid.infrastructure.service;

import com.sportPlaceGid.domain.Category;
import com.sportPlaceGid.domain.City;
import com.sportPlaceGid.infrastructure.dto.city.CityCreateDto;
import com.sportPlaceGid.infrastructure.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public CityCreateDto create(final CityCreateDto dto) {
        final City city = new City(dto.getName());
        try {
            cityRepository.save(city);
        } catch (final Exception e) {
            System.out.println(e.getLocalizedMessage());
            System.out.println("Город возможно уже есть");
        }
        dto.setId(city.getId());
        return dto;
    }

    public List<City> getAll() {
        return cityRepository.findAll();
    }

    public City findByName(String name) {
        return this.cityRepository.findByName(name);
    }

    public City getById(Long id) {
        return this.cityRepository.getOne(id);
    }
}
