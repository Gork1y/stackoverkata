package com.javamentor.qa.platform.models.entity.chat;

import java.util.UUID;
import javax.persistence.*;

import com.javamentor.qa.platform.exception.ApiRequestException;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;
import com.javamentor.qa.platform.models.entity.user.User;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "singel_chat")
public class SingleChat extends IdentifiableEntity<SingleChat, UUID> {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @MapsId
    private Chat chat = new Chat().setChatType(ChatType.SINGLE);

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User userOne;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private User useTwo;

    @PrePersist
    private void prePersistFunction() {
        checkConstraints();
    }

    @PreUpdate
    private void preUpdateFunction() {
        checkConstraints();
    }

    private void checkConstraints() {
        if (this.chat.getChatType() != ChatType.SINGLE) {
            throw new ApiRequestException("У экземпляра Chat, связанного с SingleChat, " +
                    "поле chatType должно принимать значение ChatType.SINGLE");
        }
    }
}
