package com.sportPlaceGid.infrastructure.dto.place;

import com.sportPlaceGid.domain.PlaceRouterLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PlaceRouterLevelDto {

    private Long id;

    private String name;


    public PlaceRouterLevelDto(PlaceRouterLevel level) {
        this.id = level.getId();
        this.name = level.getName();
    }
}
