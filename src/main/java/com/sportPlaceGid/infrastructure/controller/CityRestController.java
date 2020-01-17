package com.sportPlaceGid.infrastructure.controller;

import com.sportPlaceGid.domain.City;
import com.sportPlaceGid.infrastructure.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    @Autowired
    private CityService cityService;


    @GetMapping("/")
    public List<City> index() {
        return cityService.getAll();
    }

}
