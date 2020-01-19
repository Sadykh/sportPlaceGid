package com.sportPlaceGid.infrastructure.dto.place;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class PlaceDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private Long categoryId;

    @NotNull
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

    private ArrayList<PlaceServiceDto> serviceList = new ArrayList<>();
    private ArrayList<PlaceRouterDto> routerList = new ArrayList<>();
}
