package com.javamentor.qa.platform.models.dto;

import javax.validation.constraints.NotEmpty;

public record TokenResponseDto(@NotEmpty String role,
                               @NotEmpty String token) {
}
