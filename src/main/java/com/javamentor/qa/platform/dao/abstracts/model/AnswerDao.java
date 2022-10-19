package com.javamentor.qa.platform.dao.abstracts.model;

import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;

import java.util.UUID;

public interface AnswerDao extends ReadWriteDao<Answer, UUID> {
}
