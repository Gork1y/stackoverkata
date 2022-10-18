package com.javamentor.qa.platform.dao.abstracts.dto;

import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.dto.UserDto;

import java.util.Optional;
import java.util.UUID;

public interface UserDtoDao extends ReadWriteDao<UserDto, UUID> {

    Optional<UserDto> getById(UUID id);
}
