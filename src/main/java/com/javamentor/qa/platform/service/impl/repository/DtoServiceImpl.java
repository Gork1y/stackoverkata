package com.javamentor.qa.platform.service.impl.repository;

import com.javamentor.qa.platform.service.abstracts.dto.DtoService;
import java.util.List;

public abstract class DtoServiceImpl<T, U> implements DtoService<T, U> {

    protected List<T> dtoList;
    protected int totalResultCount;

    @Override
    public List<T> getItems(U u) {
        return dtoList;
    }

    @Override
    public int getTotalResultCount(U u) {
        return totalResultCount;
    }
}
