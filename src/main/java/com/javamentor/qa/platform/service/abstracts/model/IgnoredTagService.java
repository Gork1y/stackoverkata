package com.javamentor.qa.platform.service.abstracts.model;

import com.javamentor.qa.platform.models.entity.question.IgnoredTag;
import com.javamentor.qa.platform.service.abstracts.repository.ReadWriteService;

import java.util.UUID;

public interface IgnoredTagService extends ReadWriteService<IgnoredTag, UUID> {
}
