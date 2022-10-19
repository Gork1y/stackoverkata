package com.javamentor.qa.platform.service.impl.model;

import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.entity.question.IgnoredTag;
import com.javamentor.qa.platform.service.abstracts.model.IgnoredTagService;
import com.javamentor.qa.platform.service.impl.repository.ReadWriteServiceImpl;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IgnoredTagServiceImpl extends ReadWriteServiceImpl<IgnoredTag, UUID> implements IgnoredTagService {

    public IgnoredTagServiceImpl(ReadWriteDao<IgnoredTag, UUID> readWriteDao) {
        super(readWriteDao);
    }
}
