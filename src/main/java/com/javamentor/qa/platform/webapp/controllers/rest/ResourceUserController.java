package com.javamentor.qa.platform.webapp.controllers.rest;

import com.javamentor.qa.platform.models.dto.PageDto;
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
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
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

    @GetMapping()
    @Operation(summary = "Возвращает PageDto всех пользователей с пагинацией")
    @ApiResponse(responseCode = "200", description = "Успешно",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = PageDto.class)))
    @ApiResponse(responseCode = "400", description = "Таблицы User не существует")
    public ResponseEntity<PageDto<UserDto>> getAllUsersPages(@RequestParam("itemsOnPage") int itemsOnPage, @RequestParam("currentPage") int currentPage) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("workPagination", "allUsers");
        parameters.put("itemsOnPage", itemsOnPage);
        parameters.put("currentPage", currentPage);

        return ResponseEntity.ok(userDtoService.getPageDto(parameters));
    }
}
