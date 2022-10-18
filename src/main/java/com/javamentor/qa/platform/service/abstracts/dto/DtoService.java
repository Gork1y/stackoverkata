package com.javamentor.qa.platform.service.abstracts.dto;

import java.util.List;


public interface DtoService<T, U> {
    List<T> getItems(U u);
    int getTotalResultCount(U u);
}
