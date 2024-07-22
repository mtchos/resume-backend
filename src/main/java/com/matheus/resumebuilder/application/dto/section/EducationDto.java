package com.matheus.resumebuilder.application.dto.section;

import com.matheus.resumebuilder.database.postgres.types.TitledContents;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@With
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

    private UUID id;

    private UUID resumeId;

    private String createdAt;

    private String updatedAt;

    private String header;

    private String course;

    private String institution;

    private String location;

    private LocalDate startDate;

    private LocalDate endDate;

    private List<String> bulletPoints;

    private TitledContents courses;
}
