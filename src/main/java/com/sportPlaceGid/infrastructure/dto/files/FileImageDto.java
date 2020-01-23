package com.sportPlaceGid.infrastructure.dto.files;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class FileImageDto {

    @NotNull
    @NotEmpty
    private String name;


    public FileImageDto(@NotNull @NotEmpty String name) {
        this.name = name;
    }
}
