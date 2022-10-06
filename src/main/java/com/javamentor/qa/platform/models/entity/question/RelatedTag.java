package com.javamentor.qa.platform.models.entity.question;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.*;

import com.javamentor.qa.platform.models.entity.IdentifiableEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "related_tag")
public class RelatedTag extends IdentifiableEntity<RelatedTag, UUID> implements Serializable {

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "main_tag")
    private Tag mainTag;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "child_tag")
    private Tag childTag;
}
