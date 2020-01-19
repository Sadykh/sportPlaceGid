package com.sportPlaceGid.infrastructure.dto.place;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PlaceServiceDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    public PlaceServiceDto(@NotNull @NotEmpty String name) {
        this.name = name;
    }

    public PlaceServiceDto(Long id, @NotNull @NotEmpty String name) {
        this.id = id;
        this.name = name;
    }
}
