package com.javamentor.qa.platform.service.abstracts.dto;

import com.javamentor.qa.platform.models.dto.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserDtoService extends PaginationDtoService<UserDto> {
    Optional<UserDto> getById(UUID id);
}
