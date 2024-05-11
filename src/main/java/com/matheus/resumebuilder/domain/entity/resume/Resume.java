package com.matheus.resumebuilder.domain.entity.resume;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matheus.resumebuilder.domain.entity.Person;
import com.matheus.resumebuilder.domain.entity.common.TimestampableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Resume extends TimestampableEntity {

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnoreProperties("resumes")
    private Person person;

    private String code;

    private String header;

    private String role;

    private Boolean isActive;
}
