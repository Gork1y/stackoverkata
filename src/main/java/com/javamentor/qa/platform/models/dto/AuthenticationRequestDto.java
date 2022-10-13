package com.javamentor.qa.platform.models.dto;

import javax.validation.constraints.NotBlank;

public record AuthenticationRequestDto(@NotBlank String login,
                                       @NotBlank String pass) {

}
