package com.sportPlaceGid.infrastructure.controller;

import com.sportPlaceGid.domain.PlaceRouterLevel;
import com.sportPlaceGid.infrastructure.dto.place.PlaceDto;
import com.sportPlaceGid.infrastructure.service.PlaceManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/place")
public class PlaceRestController {


    @Autowired
    private PlaceManagerService placeService;

    @GetMapping("/levels")
    public List<PlaceRouterLevel> test() {
        return placeService.getAllLevels();
    }

    @PreAuthorize("#oauth2.isUser()")
    @PostMapping("/create")
    public PlaceDto create(@RequestBody @Valid PlaceDto placeDto) throws Exception {
        return placeService.createPlace(placeDto);
    }

}
