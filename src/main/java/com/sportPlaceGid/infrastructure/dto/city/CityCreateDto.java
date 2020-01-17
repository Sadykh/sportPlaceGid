package com.sportPlaceGid.infrastructure.dto.city;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CityCreateDto {

    private long id;

    @NotNull
    @NotEmpty
    private String name;

    public CityCreateDto(@NotNull @NotEmpty String name) {
        this.name = name;
    }

    public CityCreateDto(long id, @NotNull @NotEmpty String name) {
        this.id = id;
        this.name = name;
    }
}
