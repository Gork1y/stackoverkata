package com.javamentor.qa.platform.models.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Schema(description = "страница")
public class PageDto<T> {
    @Schema(description = "номер страницы")
    private int currentPageNumber;
    @Schema(description = "общее количество страниц исходя из общего количество данных в бд")
    private int totalPageCount;
    @Schema(description = "общее количество данных в бд")
    private int totalResultCount;
    @Schema(description = "сами данные")
    private List<T> items;
    @Schema(description = "количество данных на одной странице")
    private int itemsOnPage;
}
