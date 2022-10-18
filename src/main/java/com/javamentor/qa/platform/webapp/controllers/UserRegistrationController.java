package com.javamentor.qa.platform.webapp.controllers;

import com.javamentor.qa.platform.models.dto.UserRegistrationDto;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.service.abstracts.model.RoleService;
import com.javamentor.qa.platform.service.abstracts.model.UserService;
import com.javamentor.qa.platform.webapp.converters.UserConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@Controller
@RequestMapping("/api/user/registration")
public class UserRegistrationController {
    @Value("${EXPIRATION_TIME_IN_MINUTES}")
    private long expiration;
    @Value("${fromAddress}")
    private String fromAddress;
    @Value("${toAddress}")
    private String toAddress;
    @Value("${senderName}")
    private String senderName;

    private final JavaMailSender mailSender;
    private final UserConverter userConverter;
    private final UserService userService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public UserRegistrationController(JavaMailSender javaMailSender, UserConverter userConverter, UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.mailSender = javaMailSender;
        this.userConverter = userConverter;
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/verify/{email}")
    public String verify(@PathVariable String email) {
        if (userService.getByEmail(email).isEmpty()) {
            return "redirect:/registration";
        }
        User user = userService.getByEmail(email).get();
        if (user.getPersistDateTime().plusMinutes(expiration).isBefore(LocalDateTime.now())) {
            System.out.println("Время подтверждения аккаута истекло, зарегистрируйтесь заного");
            return "redirect:/registration";
        }
        user.setIsEnabled(true);
        userService.persist(user);
        return "redirect:/login";
    }

    @PostMapping("/sendMessage")
    @ResponseBody
    public ResponseEntity<UserRegistrationDto> sendMessage(@RequestBody UserRegistrationDto userRegistrationDto) {
        String email = userRegistrationDto.getEmail();
        User user = userConverter.userRegistrationDtoToUser(userRegistrationDto);
        user.setIsDeleted(false);
        user.setIsEnabled(false);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleService.getByName("ROLE_USER").orElseThrow());
        if (userService.getByEmail(email).isEmpty()) {
            sendActivationCode(email);
            userService.persist(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        User userFromDb = userService.getByEmail(email).get();
        if (userFromDb.getIsEnabled()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.delete(userFromDb);
        sendActivationCode(email);
        userService.persist(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void sendActivationCode(String email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromAddress);
        mailMessage.setTo(toAddress/*userRegistrationDto.getEmail()*/); // тестовая почта в пропертис
        mailMessage.setSubject(String.format("Подтверждение аккаунта %s", senderName));
        mailMessage.setText(String.format("Для подтверждения аккаунта перейдите по ссылке: " +
                "http://localhost:8080/api/user/registration/verify/%s", email));
        mailSender.send(mailMessage);
    }
}
