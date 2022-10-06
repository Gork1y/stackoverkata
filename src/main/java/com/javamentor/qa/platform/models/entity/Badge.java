package com.javamentor.qa.platform.models.entity;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "badges")
public class Badge extends IdentifiableEntity<Badge, UUID> implements Serializable {

    private String badgeName;

    private Integer reputationForMerit;

    private String description;
}
