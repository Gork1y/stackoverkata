package com.javamentor.qa.platform.models.entity.chat;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;

import lombok.Getter;

@Entity
@Getter
@Table(name = "chat")
public class Chat  extends IdentifiableEntity<Chat, UUID> {

    private String title;

    @Column(updatable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    @CreationTimestamp
    private LocalDateTime persistDate;

    @Enumerated
    private ChatType chatType;

    public Chat setTitle(String title) {
        this.title = title;
        return this;
    }

    public Chat setPersistDate(LocalDateTime persistDate) {
        this.persistDate = persistDate;
        return this;
    }

    public Chat setChatType(ChatType chatType) {
        this.chatType = chatType;
        return this;
    }
}
