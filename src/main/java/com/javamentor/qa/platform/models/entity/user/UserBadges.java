package com.javamentor.qa.platform.models.entity.user;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

import com.javamentor.qa.platform.models.entity.Badge;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_badges")
public class UserBadges extends IdentifiableEntity<UserBadges, UUID> implements Serializable {

    private Boolean ready;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "badges_id")
    private Badge badge;
}

