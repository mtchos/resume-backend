package com.matheus.resumebuilder.domain.entity.section;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheus.resumebuilder.domain.entity.Resume;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
public class Course {

    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

    @CreationTimestamp
    @Column(updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private Instant updatedAt;

    private String header = "Courses";

    private String course;

    private String institution;

    private String location;

    private LocalDate endDate;
}
