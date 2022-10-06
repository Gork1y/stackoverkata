package com.javamentor.qa.platform.models.entity.question;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.Type;
import com.javamentor.qa.platform.exception.ConstrainException;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;
import com.javamentor.qa.platform.models.entity.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "votes_on_questions")
@Getter
@Setter
public class VoteQuestion extends IdentifiableEntity<VoteQuestion, UUID> implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    @Column(name = "persist_date", updatable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime localDateTime = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private VoteType vote;

    @PrePersist
    private void prePersistFunction() {
        checkConstraints();
    }

    private void checkConstraints() {
        if (vote != VoteType.UP && vote != VoteType.DOWN) {
            throw new ConstrainException("В сущности VoteQuestion допускается передача значения в поле VoteTypeQ только VoteTypeQ.UP или VoteTypeQ.DOWN");
        }
    }
}
