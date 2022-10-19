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
@Schema(description = "тэг")
public class TagDto {

    public TagDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    @Parameter(description = "id тэга")
    private UUID id;
    @Schema(description = "название тэга")
    private String name;
    @Schema(description = "описание тэга")
    private String description;
}
