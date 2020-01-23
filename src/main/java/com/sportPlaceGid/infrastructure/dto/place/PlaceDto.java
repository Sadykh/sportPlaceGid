package com.sportPlaceGid.infrastructure.dto.place;

import com.sportPlaceGid.domain.Place;
import com.sportPlaceGid.infrastructure.validation.place.category.ValidCategoryExist;
import com.sportPlaceGid.infrastructure.validation.place.city.ValidCityExist;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class PlaceDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String address;

    @NotNull
    @NotEmpty
    private String latitude;

    @NotNull
    @NotEmpty
    private String longitude;

    @NotNull
    @ValidCategoryExist
    private Long categoryId;

    private String category_name;
    private String city_name;

    @NotNull
    @ValidCityExist
    private Long cityId;

    @NotNull
    @NotEmpty
    private String description;

    @NotNull
    @NotEmpty
    private String working_hours_weekday_from;

    @NotNull
    @NotEmpty
    private String working_hours_weekday_to;

    @NotNull
    @NotEmpty
    private String working_hours_weekend_from;

    @NotNull
    @NotEmpty
    private String working_hours_weekend_to;

    private List<PlaceServiceDto> serviceList = new ArrayList<>();
    private List<PlaceRouterDto> routerList = new ArrayList<>();
    private List<PlaceImageDto> imageList = new ArrayList<>();

    public PlaceDto(Place place) {
        this.id = place.getId();
        this.name = place.getName();
        this.categoryId = place.getCategory().getId();
        this.category_name = place.getCategory().getName();
        this.cityId = place.getCity().getId();
        this.city_name = place.getCity().getName();
        this.description = place.getDescription();
        this.working_hours_weekday_from = place.getWorking_hours_weekday_from();
        this.working_hours_weekday_to = place.getWorking_hours_weekday_to();
        this.working_hours_weekend_from = place.getWorking_hours_weekend_from();
        this.working_hours_weekend_to = place.getWorking_hours_weekend_to();
        this.address = place.getAddress();
        this.latitude = place.getLatitude();
        this.longitude = place.getLongitude();
        this.serviceList = place
                .getServices()
                .stream()
                .map(item -> new PlaceServiceDto(item.getId(), item.getName()))
                .collect(Collectors.toList());
        this.routerList = place
                .getRouters()
                .stream()
                .map(PlaceRouterDto::new)
                .collect(Collectors.toList());
        this.imageList = place
                .getPlaceImages()
                .stream()
                .map(PlaceImageDto::new)
                .collect(Collectors.toList());
    }
}
