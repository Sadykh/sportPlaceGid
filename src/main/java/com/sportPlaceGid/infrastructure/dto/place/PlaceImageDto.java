package com.sportPlaceGid.infrastructure.dto.place;

import com.sportPlaceGid.domain.PlaceImage;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PlaceImageDto {

    private String path;
    @NotNull
    @NotEmpty
    private String name;

    public PlaceImageDto(PlaceImage placeImage) {
        this.name = placeImage.getImage().getName();
        this.path = "http://localhost:8081/images/" + placeImage.getImage().getName();
    }
}
