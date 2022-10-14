package com.javamentor.qa.platform.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "регистрация пользователя")
public class UserRegistrationDto {
    @NotEmpty
    @Schema(description = "имя и фамилия пользователя")
    private String fullName;
    @NotEmpty
    @Schema(description = "почта пользователя")
    private String email;
    @NotEmpty
    @Schema(description = "пароль пользователя")
    private String password;
}
