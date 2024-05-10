package com.matheus.resumebuilder.domain.entity.common;

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

    @Id
    @GeneratedValue
    @JsonDeserialize
    private UUID id;
}
