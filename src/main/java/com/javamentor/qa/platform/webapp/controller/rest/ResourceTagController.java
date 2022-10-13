package com.javamentor.qa.platform.webapp.controller.rest;

import com.javamentor.qa.platform.models.dto.RelatedTagDto;
import com.javamentor.qa.platform.service.abstracts.dto.TagDtoService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user/tag")
@Schema(description = "контроллер тэгов")
public class ResourceTagController {

    private final TagDtoService tagDtoService;


    public ResourceTagController(TagDtoService tagDtoService) {
        this.tagDtoService = tagDtoService;
    }

    @Schema(description = "получить топ-10 тэгов")
    @GetMapping("/related")
    public ResponseEntity<List<RelatedTagDto>> getTopTags() {
        List<RelatedTagDto> relatedTagDtos = tagDtoService.getTopTags();
        return new ResponseEntity<>(relatedTagDtos, HttpStatus.OK);
    }
}
