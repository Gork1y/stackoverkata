package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.service.abstracts.model.AnswerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Tag(name = "Answer контроллер", description = "Api для работы с вопросами")
@RequestMapping("api/user/question/{questionId}/answer")
public class ResourceAnswerController {

    private AnswerService answerService;

    @DeleteMapping("/{answerId}")
    @Operation(summary = "Удаляет ответ на вопрос по ID")
    @ApiResponse(responseCode = "200", description = "Успешно")
    @ApiResponse(responseCode = "204", description = "Ответа на вопрос по ID не существует")
    public ResponseEntity<Void> deleteAnswer(@PathVariable("answerId") UUID answerId) {
        Optional<Answer> answerOpt = answerService.getById(answerId);
        if (answerOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        Answer answer = answerOpt.get();
        answer.setIsDeleted(true);
        answerService.persist(answer);
        return ResponseEntity.ok().build();
    }
}
