package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.entity.question.Tag;
import com.javamentor.qa.platform.service.abstracts.model.TagService;
import com.javamentor.qa.platform.service.impl.repository.ReadWriteServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TagServiceImpl extends ReadWriteServiceImpl<Tag, UUID> implements TagService {

    public TagServiceImpl(ReadWriteDao<Tag, UUID> readWriteDao) {
        super(readWriteDao);
    }
}
