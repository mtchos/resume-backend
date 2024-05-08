package com.matheus.resumebuilder.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matheus.resumebuilder.business.entity.common.TimestampableEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Resume extends TimestampableEntity {

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnoreProperties("resumes")
    private Person person;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("resume")
    private List<Section> sections;

    private String name;

    private Boolean isActive;
}
