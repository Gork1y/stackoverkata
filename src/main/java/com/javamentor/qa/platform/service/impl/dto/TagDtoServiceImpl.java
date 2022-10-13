package com.javamentor.qa.platform.service.impl.dto;

import com.javamentor.qa.platform.dao.abstracts.dto.TagDtoDao;
import com.javamentor.qa.platform.dao.abstracts.repository.ReadWriteDao;
import com.javamentor.qa.platform.models.dto.RelatedTagDto;
import com.javamentor.qa.platform.service.abstracts.dto.TagDtoService;
import com.javamentor.qa.platform.service.impl.repository.ReadWriteServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagDtoServiceImpl extends ReadWriteServiceImpl<RelatedTagDto, Long> implements TagDtoService {

    private final TagDtoDao tagDtoDao;

    public TagDtoServiceImpl(ReadWriteDao<RelatedTagDto, Long> readWriteDao, TagDtoDao tagDtoDao) {
        super(readWriteDao);
        this.tagDtoDao = tagDtoDao;
    }

    @Override
    public List<RelatedTagDto> getTop10Tags() {
        return tagDtoDao.getTop10Tags();
    }
}
