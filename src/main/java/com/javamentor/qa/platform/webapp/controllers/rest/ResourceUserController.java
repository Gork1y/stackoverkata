package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.models.dto.UserDto;
import com.javamentor.qa.platform.service.abstracts.dto.UserDtoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@AllArgsConstructor
@Tag(name = "User контроллер", description = "Api для работы с пользователями")
@RequestMapping("/api/user")
public class ResourceUserController {

    private final UserDtoService userDtoService;

    @GetMapping("/{id}")
    @Operation(summary = "Возвращает DTO пользователя по Id")
    @ApiResponse(responseCode = "200", description = "успешно",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = UserDto.class)))
    @ApiResponse(responseCode = "400", description = "Пользователя по Id не существует")
    public ResponseEntity<UserDto> getQuestion(@PathVariable("id") UUID userId) {
        Optional<UserDto> userDto = userDtoService.getById(userId);
        return userDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }
}
