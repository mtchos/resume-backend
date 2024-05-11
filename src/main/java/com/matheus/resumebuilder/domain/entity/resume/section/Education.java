package com.matheus.resumebuilder.domain.entity.resume.section;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheus.resumebuilder.domain.entity.resume.Resume;
import com.matheus.resumebuilder.domain.entity.common.TimestampableEntity;
import com.matheus.resumebuilder.database.pgtype.TitledContents;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Education extends TimestampableEntity {

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

    private String header = "Education";

    private String course;

    private String institution;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    private TitledContents bulletPoints;
}
