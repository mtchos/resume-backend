package com.matheus.resumebuilder.domain.entity.resume.section;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheus.resumebuilder.domain.entity.resume.Resume;
import com.matheus.resumebuilder.domain.entity.common.TimestampableEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Course extends TimestampableEntity {

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

    private String header = "Courses";

    private String course;

    private String institution;

    private String location;

    private LocalDate endDate;
}
