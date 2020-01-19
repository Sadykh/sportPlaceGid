package com.sportPlaceGid.infrastructure.service;

import com.sportPlaceGid.domain.*;
import com.sportPlaceGid.infrastructure.dto.place.PlaceDto;
import com.sportPlaceGid.infrastructure.dto.place.PlaceRouterDto;
import com.sportPlaceGid.infrastructure.dto.place.PlaceServiceDto;
import com.sportPlaceGid.infrastructure.repository.PlaceRepository;
import com.sportPlaceGid.infrastructure.repository.PlaceRouterLevelRepository;
import com.sportPlaceGid.infrastructure.repository.PlaceRouterRepository;
import com.sportPlaceGid.infrastructure.repository.PlaceServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlaceManagerService {

    @Autowired
    private PlaceRepository placeRepository;

    @Autowired
    private PlaceServiceRepository placeServiceRepository;

    @Autowired
    private PlaceRouterLevelRepository placeRouterLevelRepository;

    @Autowired
    private PlaceRouterRepository placeRouterRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CityService cityService;

    public List<PlaceRouterLevel> getAllLevels() {
        return placeRouterLevelRepository.findAll();
    }

    public void createPlaceRouterLevel(String name) {
        PlaceRouterLevel level = new PlaceRouterLevel(name);
        try {
            placeRouterLevelRepository.save(level);
        } catch (final Exception e) {
            System.out.println("Сложность трассы уже в базе");
        }
    }

    public void savePlaceService(Place place, ArrayList<PlaceServiceDto> serviceList) {
        serviceList.forEach(item -> {
            PlaceService service = new PlaceService(item.getName(), place);
            this.placeServiceRepository.save(service);
        });
    }

    public void saveRouters(Place place, ArrayList<PlaceRouterDto> routerList) {
        routerList.forEach(item -> {
            PlaceRouterLevel level = this.placeRouterLevelRepository.getOne(item.getLevelId());
            PlaceRouter router = new PlaceRouter(item.getName(), item.getHeight(), item.getLength(), level, place);
            this.placeRouterRepository.save(router);
        });
    }


    public PlaceDto createPlace(PlaceDto dto) throws Exception {
        Category category = categoryService.getById(dto.getCategoryId());
        City city = cityService.getById(dto.getCityId());
        if (category == null) {
            throw new Exception("Категория не найдена");
        }
        if (city == null) {
            throw new Exception("Город не найден");
        }
        Place place = new Place(dto.getName(), category, city, dto.getDescription(), dto.getWorking_hours_weekday_from(), dto.getWorking_hours_weekday_to(), dto.getWorking_hours_weekend_from(), dto.getWorking_hours_weekend_to());
        placeRepository.save(place);
        dto.setId(place.getId());
        this.savePlaceService(place, dto.getServiceList());
        this.saveRouters(place, dto.getRouterList());

        return dto;
    }
}
