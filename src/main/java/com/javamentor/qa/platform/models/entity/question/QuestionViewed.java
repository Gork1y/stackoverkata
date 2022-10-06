package com.javamentor.qa.platform.models.entity.question;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;
import com.javamentor.qa.platform.models.entity.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "question_viewed")
@Getter
@Setter
public class QuestionViewed extends IdentifiableEntity<QuestionViewed, UUID> implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id")
    private Question question;

    @Column(name = "persist_date", updatable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime localDateTime = LocalDateTime.now();

}



