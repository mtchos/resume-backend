package com.matheus.resumebuilder.domain.entity.section;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.matheus.resumebuilder.database.pgtype.TitledContents;
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
public class Experience {

    @Id
    private UUID id;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Instant updatedAt;

    @ManyToOne
    @JoinColumn(name = "resume_id")
    @JsonIgnore
    private Resume resume;

    private String header = "Experience";

    private String role;

    private String company;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    private TitledContents bulletPoints;


}
