package com.sportPlaceGid.infrastructure.controller;

import com.sportPlaceGid.domain.Place;
import com.sportPlaceGid.domain.PlaceRouterLevel;
import com.sportPlaceGid.infrastructure.dto.place.PlaceDto;
import com.sportPlaceGid.infrastructure.dto.place.PlaceRouterLevelDto;
import com.sportPlaceGid.infrastructure.service.PlaceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/place")
public class PlaceRestController {


    @Autowired
    private PlaceManagerService placeService;

    @GetMapping("/levels")
    public List<PlaceRouterLevelDto> levels() {
        List<PlaceRouterLevel> levels = placeService.getAllLevels();
        return levels
                .stream()
                .map(PlaceRouterLevelDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/")
    public List<PlaceDto> index() {
        List<Place> places = placeService.getAll();
        return places
                .stream()
                .map(PlaceDto::new)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PlaceDto getOneById(@PathVariable String id) {
        Place place = placeService.getOne(Long.parseLong(id));
        return new PlaceDto(place);
    }

    @PreAuthorize("#oauth2.isUser()")
    @PostMapping("/create")
    public PlaceDto create(@RequestBody @Valid PlaceDto placeDto) throws Exception {
        return placeService.createPlace(placeDto);
    }

}
