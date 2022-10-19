package com.javamentor.qa.platform.service.abstracts.dto;

import com.javamentor.qa.platform.models.dto.RelatedTagDto;
import com.javamentor.qa.platform.models.dto.TagDto;
import com.javamentor.qa.platform.models.entity.user.User;

import java.util.List;

public interface TagDtoService {
    List<RelatedTagDto> getTop10Tags();
    List<TagDto> getIgnoredTags(User user);
}
