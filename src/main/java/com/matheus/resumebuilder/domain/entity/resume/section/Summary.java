package com.matheus.resumebuilder.domain.entity.resume.section;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheus.resumebuilder.domain.entity.resume.Resume;
import com.matheus.resumebuilder.domain.entity.common.TimestampableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Summary extends TimestampableEntity {

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

    private String header = "Summary";

    private String content;
}
