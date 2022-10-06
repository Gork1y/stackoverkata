package com.javamentor.qa.platform.models.entity.question.answer;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

import com.javamentor.qa.platform.exception.ApiRequestException;
import com.javamentor.qa.platform.models.entity.Comment;
import com.javamentor.qa.platform.models.entity.CommentType;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;
import com.javamentor.qa.platform.models.entity.user.User;

import lombok.Getter;

@Entity
@Getter
@Table(name = "comment_answer")
public class CommentAnswer extends IdentifiableEntity<Answer, UUID> implements Serializable {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @MapsId
    private Comment comment = new Comment().setCommentType(CommentType.ANSWER);

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @PrePersist
    private void prePersistFunction() {
        checkConstraints();
    }

    @PreUpdate
    private void preUpdateFunction() {
        checkConstraints();
    }

    private void checkConstraints() {
        if (this.comment.getCommentType() != CommentType.ANSWER) {
            throw new ApiRequestException("У экземпляра Comment, связанного с CommentAnswer, " +
                    "поле commentType должно принимать значение CommentType.ANSWER");
        }
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public void setText(String text) {
        comment.setText(text);
    }

    public void setUser(User user) {
        comment.setUser(user);
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
