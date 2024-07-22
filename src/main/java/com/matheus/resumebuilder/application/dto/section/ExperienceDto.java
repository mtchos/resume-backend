package com.matheus.resumebuilder.application.dto.section;

import com.matheus.resumebuilder.database.postgres.types.TitledContents;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@With
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ExperienceDto {

    private UUID id;

    private UUID resumeId;

    private Instant createdAt;

    private Instant updatedAt;

    private String header;

    private String role;

    private String company;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    private TitledContents bulletPoints;

    private List<String> skills;
}
