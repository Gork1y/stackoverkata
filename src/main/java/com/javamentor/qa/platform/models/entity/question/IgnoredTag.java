package com.javamentor.qa.platform.models.entity.question;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;
import com.javamentor.qa.platform.models.entity.user.User;

import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "tag_ignore")
public class IgnoredTag extends IdentifiableEntity<IgnoredTag, UUID> implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Tag ignoredTag;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User user;

    @CreationTimestamp
    @Column(name = "persist_date", updatable = false)
    @Type(type = "org.hibernate.type.LocalDateTimeType")
    private LocalDateTime persistDateTime;

}
