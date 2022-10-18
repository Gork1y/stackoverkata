package com.javamentor.qa.platform.service.abstracts.dto;

import java.util.List;

public interface PaginationDto<T> {
    List<T> getItems(Object parameter);

    int getTotalResultCount(Object parameter);
}
