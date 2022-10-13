package com.javamentor.qa.platform.service.abstracts.dto;

import com.javamentor.qa.platform.models.dto.QuestionDto;
import com.javamentor.qa.platform.service.abstracts.repository.ReadWriteService;
import org.springframework.security.core.Authentication;

import java.util.Optional;

public interface QuestionDtoService extends ReadWriteService<QuestionDto, Long> {
    Optional<QuestionDto> getById(Long questionId, Authentication auth);
}
