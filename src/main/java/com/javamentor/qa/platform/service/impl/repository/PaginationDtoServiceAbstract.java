package com.javamentor.qa.platform.service.impl.repository;

import com.javamentor.qa.platform.models.dto.PageDto;
import com.javamentor.qa.platform.service.abstracts.repository.PaginationDtoService;

import java.util.Map;

public abstract class PaginationDtoServiceAbstract<T> implements PaginationDtoService<T> {

    @Override
    public PageDto<T> getPageDto(Map<String, Object> parameters) {
        PageDto<T> pageDto = new PageDto<T>();

        return pageDto;
    }
}
