package com.javamentor.qa.platform.models.entity.user;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import com.javamentor.qa.platform.models.entity.IdentifiableEntity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role extends IdentifiableEntity<Role, UUID> implements GrantedAuthority {

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
