package com.javamentor.qa.platform.dao.abstracts.dto;

import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.dto.QuestionDto;

import java.util.Optional;
import java.util.UUID;

public interface QuestionDtoDao extends ReadWriteDao<QuestionDto, Long> {
    Optional<QuestionDto> getById(UUID questionId, UUID authorizedUserId);
}
