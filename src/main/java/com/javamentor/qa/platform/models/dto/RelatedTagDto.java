package com.javamentor.qa.platform.models.dto;


import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Schema(description = "Связанный тэг")
public class RelatedTagDto {
    @Parameter(description = "id тэга")
    private UUID id;
    @Schema(description = "описание тэга")
    private String title;
    @Schema(description = "количество вопросов в которых упоминается тэг")
    private int countQuestion;
}
