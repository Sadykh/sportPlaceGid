package com.sportPlaceGid.infrastructure.service;

import com.sportPlaceGid.domain.PlaceRouterLevel;
import com.sportPlaceGid.infrastructure.repository.PlaceRepository;
import com.sportPlaceGid.infrastructure.repository.PlaceRouterLevelRepository;
import com.sportPlaceGid.infrastructure.repository.PlaceRouterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaceService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceRouterLevelRepository placeRouterLevelRepository;

    @Autowired
    private PlaceRouterRepository placeRouterRepository;


    public void createPlaceRouterLevel(String name) {
        PlaceRouterLevel level = new PlaceRouterLevel(name);
        try {
            placeRouterLevelRepository.save(level);
        } catch (final Exception e) {
            System.out.println("Сложность трассы уже в базе");
        }
    }
}
