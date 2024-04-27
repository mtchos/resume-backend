package com.matheus.resumebuilder.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.matheus.resumebuilder.model.type.TextType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
public class Text {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "section_id")
    @JsonBackReference
    private Section section;

    private String content;

    private TextType type;

    private String place;

    private String location;

    private String startDate;

    private String endDate;
}
