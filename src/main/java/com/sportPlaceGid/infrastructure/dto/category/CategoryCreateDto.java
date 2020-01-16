package com.sportPlaceGid.infrastructure.dto.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class CategoryCreateDto {

    private long id;

    @NotNull
    @NotEmpty
    private String name;

    public CategoryCreateDto(@NotNull @NotEmpty String name) {
        this.name = name;
    }

    public CategoryCreateDto(long id, @NotNull @NotEmpty String name) {
        this.id = id;
        this.name = name;
    }
}
