package com.javamentor.qa.platform.models.entity.question;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import com.javamentor.qa.platform.exception.ConstrainException;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tag")
public class Tag extends IdentifiableEntity<Tag, UUID> implements Serializable {

    private String name;
    private String description;

    @CreationTimestamp
    @Column(name = "persist_date", updatable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime persistDateTime;

    @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
    private List<Question> questions;

    @PrePersist
    private void prePersistFunction() {
        checkConstraints();
    }

    @PreUpdate
    private void preUpdateFunction() {
        checkConstraints();
    }

    private void checkConstraints() {
        if (this.description.isEmpty()) {
            throw new ConstrainException("Поле description не должно быть пустым");
        }
        if (this.name.isEmpty()) {
            throw new ConstrainException("Поле name не должно быть пустым");
        }
    }
}
