package com.javamentor.qa.platform.models.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;
import com.javamentor.qa.platform.models.entity.user.User;

import lombok.Getter;

@Entity
@Getter
@Table(name = "comment")
public class Comment extends IdentifiableEntity<BookMarks, UUID> implements Serializable {

    private String text;

    @Enumerated
    private CommentType commentType;

    @Column(name = "persist_date", updatable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @CreationTimestamp
    private LocalDateTime persistDateTime;

    @Column(name = "last_redaction_date")
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @UpdateTimestamp
    private LocalDateTime lastUpdateDateTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User user;

    public Comment setText(String text) {
        this.text = text;
        return this;
    }

    public Comment setCommentType(CommentType commentType) {
        this.commentType = commentType;
        return this;
    }

    public Comment setPersistDateTime(LocalDateTime persistDateTime) {
        this.persistDateTime = persistDateTime;
        return this;
    }

    public Comment setLastUpdateDateTime(LocalDateTime lastUpdateDateTime) {
        this.lastUpdateDateTime = lastUpdateDateTime;
        return this;
    }

    public Comment setUser(User user) {
        this.user = user;
        return this;
    }
}
