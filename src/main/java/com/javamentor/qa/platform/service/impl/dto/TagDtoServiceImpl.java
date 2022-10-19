package com.javamentor.qa.platform.service.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.TagDtoDao;
import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.dto.RelatedTagDto;
import com.javamentor.qa.platform.models.dto.TagDto;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.service.abstracts.dto.TagDtoService;
import com.javamentor.qa.platform.service.impl.repository.ReadWriteServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TagDtoServiceImpl extends ReadWriteServiceImpl<RelatedTagDto, UUID> implements TagDtoService {

    private final TagDtoDao tagDtoDao;

    public TagDtoServiceImpl(ReadWriteDao<RelatedTagDto, UUID> readWriteDao, TagDtoDao tagDtoDao) {
        super(readWriteDao);
        this.tagDtoDao = tagDtoDao;
    }

    @Override
    public List<RelatedTagDto> getTop10Tags() {
        return tagDtoDao.getTop10Tags();
    }

    @Override
    public List<TagDto> getIgnoredTags(User user) {
        return tagDtoDao.getIgnoredTags(user.getId());
    }
}
