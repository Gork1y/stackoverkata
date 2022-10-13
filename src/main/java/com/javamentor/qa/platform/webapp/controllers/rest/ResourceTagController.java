package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.models.dto.RelatedTagDto;
import com.javamentor.qa.platform.service.abstracts.dto.TagDtoService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/tag")
@Schema(description = "контроллер тэгов")
public class ResourceTagController {

    private final TagDtoService tagDtoService;

    public ResourceTagController(TagDtoService tagDtoService) {
        this.tagDtoService = tagDtoService;
    }

    @Schema(description = "Возвращает лист содержащий топ-10 тегов")
    @ApiResponse(responseCode = "200", description = "успешно",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = RelatedTagDto.class)))
    @GetMapping("/related")
    public ResponseEntity<List<RelatedTagDto>> getTop10Tags() {
        return new ResponseEntity<>(tagDtoService.getTop10Tags(), HttpStatus.OK);
    }
}
