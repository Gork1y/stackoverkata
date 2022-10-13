package com.javamentor.qa.platform.webapp.controllers.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javamentor.qa.platform.models.dto.AuthenticationRequestDto;
import com.javamentor.qa.platform.models.dto.TokenResponseDto;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.security.jwt.JwtTokenUtil;
import com.javamentor.qa.platform.webapp.WebConstants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "Контроллер аутентификации", description = "Работа с сессиями пользователей")
@Validated
@RestController
@RequestMapping(WebConstants.AUTH_URL)
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/token")
    @ApiResponse(responseCode = "200", description = WebConstants.CODE_200_MESSAGE)
    @ApiResponse(responseCode = "400", description = WebConstants.CODE_400_MESSAGE)
    @Operation(summary = "Аутентификация пользователя по логину и паролю")
    public ResponseEntity<TokenResponseDto> authentication(@Valid @RequestBody AuthenticationRequestDto authenticationRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        authenticationRequest.login(),
                        authenticationRequest.pass()));

        User user = (User) authentication.getPrincipal();
        String token = jwtTokenUtil.generateToken(user);

        return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, token)
                .body(new TokenResponseDto(user.getRole().getName(), token));

    }

    @PostMapping("/logout")
    @ApiResponse(responseCode = "200", description = WebConstants.CODE_200_MESSAGE)
    @Operation(summary = "Логаут")
    public void logout(HttpServletResponse response, HttpServletRequest request) {
    }
}

