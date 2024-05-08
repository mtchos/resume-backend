package com.matheus.resumebuilder.business.entity.common;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class IdentifiableEntity implements Serializable {

    private String getLowercaseClassName() {
        return getClass().getSimpleName().toLowerCase();
    }

    @Id
    @GeneratedValue
    @JsonDeserialize
    private UUID id;
}
