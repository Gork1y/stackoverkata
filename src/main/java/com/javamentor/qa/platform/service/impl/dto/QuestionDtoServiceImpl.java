package com.javamentor.qa.platform.service.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.QuestionDtoDao;
import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.dto.QuestionDto;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.service.abstracts.dto.QuestionDtoService;
import com.javamentor.qa.platform.service.impl.repository.ReadWriteServiceImpl;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QuestionDtoServiceImpl extends ReadWriteServiceImpl<QuestionDto, Long> implements QuestionDtoService {

    QuestionDtoDao questionDtoDao;

    public QuestionDtoServiceImpl(ReadWriteDao<QuestionDto, Long> readWriteDao,
                                  QuestionDtoDao questionDtoDao) {
        super(readWriteDao);
        this.questionDtoDao = questionDtoDao;
    }

    @Override
    public Optional<QuestionDto> getById(Long questionId, Authentication auth) {
        Long authorizedUserId;
        if (auth != null) {
            User user = (User) auth.getPrincipal();
            authorizedUserId = user.getId();
        } else {
            authorizedUserId = null;
        }
        return questionDtoDao.getById(questionId, authorizedUserId);
    }
}
