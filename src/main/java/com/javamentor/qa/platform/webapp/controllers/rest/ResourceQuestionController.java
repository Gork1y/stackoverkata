package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.models.dto.QuestionDto;
import com.javamentor.qa.platform.service.abstracts.dto.QuestionDtoService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ResourceQuestionController {

    private final QuestionDtoService questionDtoService;

    @GetMapping("/api/user/question/{id}")
    @ApiResponse(description = "Получение DTO вопроса по его ID")
    public ResponseEntity<QuestionDto> getQuestion(@PathVariable("id") Long questionId, Authentication auth) {
        QuestionDto questionDto = questionDtoService.getById(questionId, auth).orElse(new QuestionDto());
        return new ResponseEntity<>(questionDto, HttpStatus.OK);
    }
}
