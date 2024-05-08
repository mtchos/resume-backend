package com.matheus.resumebuilder.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matheus.resumebuilder.business.entity.category.TextCategory;
import com.matheus.resumebuilder.business.entity.common.TimestampableEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Text extends TimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonIgnoreProperties("texts")
    private Section section;

    private String content;

    private TextCategory type;
}
