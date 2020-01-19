package com.sportPlaceGid.infrastructure.dto.place;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class PlaceRouterDto {

    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private Long levelId;

    @NotNull
    private Integer height;

    @NotNull
    private Integer length;

    public PlaceRouterDto(@NotNull @NotEmpty String name, @NotNull Long levelId, @NotNull Integer height, @NotNull @NotEmpty Integer length) {
        this.name = name;
        this.levelId = levelId;
        this.height = height;
        this.length = length;
    }
}
