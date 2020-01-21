package com.sportPlaceGid.infrastructure.dto.user;

import com.sportPlaceGid.infrastructure.validation.user.email.ValidEmailUnique;
import com.sportPlaceGid.infrastructure.validation.user.password.ValidPassword;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class UserCreateDto {

    private long id;

    @NotNull
    @NotEmpty
    @Email
    @ValidEmailUnique
    private String email;

    @NotNull
    @NotEmpty
    private String name;

    @ValidPassword
    private String password;


    public UserCreateDto(@NotNull @NotEmpty @Email String email, @NotNull @NotEmpty String name, @NotNull @NotEmpty @Size(min = 6) String password) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    public UserCreateDto(long id, @NotNull @NotEmpty @Email String email, @NotNull @NotEmpty String name, @NotNull @NotEmpty @Size(min = 6) String password) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
    }
}
