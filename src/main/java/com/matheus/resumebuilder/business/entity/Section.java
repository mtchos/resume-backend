package com.matheus.resumebuilder.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.matheus.resumebuilder.business.entity.category.SectionCategory;
import com.matheus.resumebuilder.business.entity.common.TimestampableEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Section extends TimestampableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonIgnoreProperties("sections")
    private Resume resume;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("section")
    private List<Text> texts;

    private SectionCategory type;

    private Integer displayOrder;
}
