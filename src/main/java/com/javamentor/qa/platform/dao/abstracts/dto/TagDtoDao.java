package com.javamentor.qa.platform.dao.abstracts.dto;

import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.dto.RelatedTagDto;
import com.javamentor.qa.platform.models.dto.TagDto;

import java.util.List;
import java.util.UUID;

public interface TagDtoDao extends ReadWriteDao<RelatedTagDto, UUID> {

    List<RelatedTagDto> getTop10Tags();
    List<TagDto> getTop3TagsByUser(UUID userId);
    List<TagDto> getIgnoredTags(UUID userId);
}
