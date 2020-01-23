package com.sportPlaceGid.infrastructure.service;

import com.sportPlaceGid.domain.*;
import com.sportPlaceGid.infrastructure.dto.place.PlaceDto;
import com.sportPlaceGid.infrastructure.dto.place.PlaceImageDto;
import com.sportPlaceGid.infrastructure.dto.place.PlaceRouterDto;
import com.sportPlaceGid.infrastructure.dto.place.PlaceServiceDto;
import com.sportPlaceGid.infrastructure.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

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
    private PlaceImageRepository placeImageRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CityService cityService;

    @Autowired
    private FileImageService fileImageService;

    public List<PlaceRouterLevel> getAllLevels() {
        return placeRouterLevelRepository.findAll();
    }

    public List<Place> getAll() {
        return placeRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    public Place getOne(Long id) {
        return placeRepository.getOne(id);
    }


    public PlaceRouterLevel getOneLevelRouter(Long id) {
        return this.placeRouterLevelRepository.getOne(id);
    }


    public void createPlaceRouterLevel(String name) {
        PlaceRouterLevel level = new PlaceRouterLevel(name);
        try {
            placeRouterLevelRepository.save(level);
        } catch (final Exception e) {
            System.out.println("Сложность трассы уже в базе");
        }
    }

    public void savePlaceService(Place place, List<PlaceServiceDto> serviceList) {
        serviceList.forEach(item -> {
            PlaceService service = new PlaceService(item.getName(), place);
            this.placeServiceRepository.save(service);
        });
    }

    public void saveRouters(Place place, List<PlaceRouterDto> routerList) {
        routerList.forEach(item -> {
            try {
                PlaceRouterLevel level = this.placeRouterLevelRepository.getOne(item.getLevelId());
                PlaceRouter router = new PlaceRouter(item.getName(), item.getHeight(), item.getLength(), level, place);
                this.placeRouterRepository.save(router);
            } catch (Exception exception) {
                System.out.println(exception.getLocalizedMessage());
            }

        });
    }

    public void saveImages(Place place, List<PlaceImageDto> imageList) {
        imageList.forEach(item -> {
            try {
                FileImage fileImage = this.fileImageService.findByName(item.getName());
                PlaceImage placeImage = new PlaceImage(place, fileImage);
                this.placeImageRepository.save(placeImage);
            } catch (Exception exception) {
                System.out.println(exception.getLocalizedMessage());
            }

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
        Place place = new Place(dto, category, city);
        placeRepository.save(place);
        dto.setId(place.getId());
        this.savePlaceService(place, dto.getServiceList());
        this.saveRouters(place, dto.getRouterList());
        this.saveImages(place, dto.getImageList());

        return dto;
    }
}
