package com.sportPlaceGid.infrastructure.controller;

import com.sportPlaceGid.domain.City;
import com.sportPlaceGid.infrastructure.dto.city.CityCreateDto;
import com.sportPlaceGid.infrastructure.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    @Autowired
    private CityService cityService;


    @GetMapping("/")
    public List<CityCreateDto> index() {
        List<City> cities = cityService.getAll();
        return cities
                .stream()
                .map(item -> new CityCreateDto(item.getId(), item.getName()))
                .collect(Collectors.toList());
    }

}
