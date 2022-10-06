package com.javamentor.qa.platform.models.entity.question;

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
@Table(name = "comment_question")
public class CommentQuestion  extends IdentifiableEntity<CommentQuestion, UUID> implements Serializable {

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @MapsId
    private Comment comment = new Comment().setCommentType(CommentType.QUESTION);

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "question_id")
    private Question question;


    @PrePersist
    private void prePersistFunction() {
        checkConstraints();
    }

    @PreUpdate
    private void preUpdateFunction() {
        checkConstraints();
    }

    private void checkConstraints() {
        if (this.comment.getCommentType() != CommentType.QUESTION) {
            throw new ApiRequestException("У экземпляра Comment, связанного с CommentQuestion, " +
                    "поле commentType должно принимать значение CommentType.QUESTION");
        }
    }

    public void setQuestion(Question question) {
        this.question = question;
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
