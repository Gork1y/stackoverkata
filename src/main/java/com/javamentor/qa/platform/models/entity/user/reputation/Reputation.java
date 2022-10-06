package com.javamentor.qa.platform.models.entity.user.reputation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;
import com.javamentor.qa.platform.models.entity.question.Question;
import com.javamentor.qa.platform.models.entity.question.answer.Answer;
import com.javamentor.qa.platform.models.entity.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@CombinedNotNullQuestionOrAnswer
@Table(name = "reputation")
public class Reputation extends IdentifiableEntity<Reputation, UUID> implements Serializable {

    @CreationTimestamp
    @Column(updatable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime persistDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private User author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private User sender;

    private Integer count;

    @Enumerated
    private ReputationType type;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Question.class, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Answer.class, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "answer_id")
    private Answer answer;
}
