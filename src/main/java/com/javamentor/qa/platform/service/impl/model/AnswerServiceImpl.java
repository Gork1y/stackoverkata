package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.service.abstracts.model.AnswerService;
import com.javamentor.qa.platform.service.impl.repository.ReadWriteServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AnswerServiceImpl extends ReadWriteServiceImpl<Answer, UUID> implements AnswerService {

    public AnswerServiceImpl(ReadWriteDao<Answer, UUID> readWriteDao) {
        super(readWriteDao);
    }
}
