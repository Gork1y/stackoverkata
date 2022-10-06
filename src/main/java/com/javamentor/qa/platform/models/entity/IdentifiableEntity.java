package com.javamentor.qa.platform.models.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class IdentifiableEntity<B, I extends Serializable> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Override
    public int hashCode() {
        return Objects.hash(getClass(), id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj instanceof IdentifiableEntity<?, ?>) {
            return equals(this, (IdentifiableEntity<?, ?>) obj);
        } else {
            return false;
        }
    }

    private static boolean equals(IdentifiableEntity<?, ?> a, IdentifiableEntity<?, ?> b) {
        Class<?> aClass = a.getClass();
        Class<?> bClass = b.getClass();

        if (aClass == null || bClass == null) {
            return false;
        }

        if (aClass.equals(bClass)) {
            Object aId = a.id;
            Object bId = b.id;

            if (aId == null || bId == null) {
                return false;
            } else {
                return aId.equals(bId);
            }
        } else {
            return false;
        }
    }
}
