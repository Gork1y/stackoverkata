package com.javamentor.qa.platform.service.abstracts.dto;

import com.javamentor.qa.platform.models.dto.UserDto;
import com.javamentor.qa.platform.service.abstracts.repository.ReadWriteService;

import java.util.Optional;
import java.util.UUID;

public interface UserDtoService  {
    Optional<UserDto> getById(UUID id);
}
