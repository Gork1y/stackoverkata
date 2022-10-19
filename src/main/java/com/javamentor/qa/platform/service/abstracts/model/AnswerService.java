package com.javamentor.qa.platform.service.abstracts.model;

import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.service.abstracts.repository.ReadWriteService;

import java.util.UUID;

public interface AnswerService extends ReadWriteService<Answer, UUID> {
}
