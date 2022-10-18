package com.javamentor.qa.platform.service.abstracts.model;

import com.javamentor.qa.platform.models.entity.question.Tag;
import com.javamentor.qa.platform.service.abstracts.repository.ReadWriteService;

import java.util.UUID;

public interface TagService extends ReadWriteService<Tag, UUID> {

}
