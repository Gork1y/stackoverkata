package com.javamentor.qa.platform.controller.rest;

import com.javamentor.qa.platform.service.abstracts.model.QuestionService;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user/question")
@Schema(description = "контроллер вопросов")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Schema(description = "получить общее количество вопросов в базе данных")
    @GetMapping("/count")
    public ResponseEntity<Long> getCountQuestion() {
        return ResponseEntity.ok(questionService.getQuestionCount().get());
    }
}
