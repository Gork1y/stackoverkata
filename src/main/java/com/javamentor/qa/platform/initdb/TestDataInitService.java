package com.javamentor.qa.platform.initdb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.javamentor.qa.platform.models.entity.question.Question;
import com.javamentor.qa.platform.models.entity.question.Tag;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.models.entity.user.Role;
import com.javamentor.qa.platform.models.entity.user.User;
import com.javamentor.qa.platform.models.entity.user.reputation.Reputation;
import com.javamentor.qa.platform.service.abstracts.model.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestDataInitService {
    private final UserService userService;

    @Transactional
    @PostConstruct
    public void createEntity() {
        createUsers();
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    List<User> users = List.of(
            User.builder()
                    .nickname("user")
                    .fullName("user")
                    .email("user@email.com")
                    .role(new Role(1L, "ROLE_USER"))
                    .password("$2a$12$4XwZRmpBn2VoQSQL8HVV.O2rYFM.8Eq3HOhy3SNnKi0kmVfYzINna") // password:111
                    .build(),
            User.builder()
                    .nickname("admin")
                    .fullName("admin")
                    .email("admin@email.com")
                    .role(new Role(2L, "ROLE_ADMIN"))
                    .password("$2a$12$4XwZRmpBn2VoQSQL8HVV.O2rYFM.8Eq3HOhy3SNnKi0kmVfYzINna") // password:111
                    .build());


    private void createUsers() {
        userService.persistAll(users);
    }

    List<Tag> tags = new ArrayList<>();

    private void createTags() {

    }

    List<Question> questions = new ArrayList<>();

    private void createQuestions() {

    }

    List<Answer> answers = new ArrayList<>();

    private void createAnswers() {

    }

    List<Reputation> reputations = new ArrayList<>();

    private void createReputations() {

    }
}
