package com.matheus.resumebuilder.application.dto.section;

import com.matheus.resumebuilder.database.postgres.types.TitledKeywords;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.time.Instant;
import java.util.UUID;

@Getter
@With
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SkillDto {

    private UUID id;

    private UUID resumeId;

    private Instant createdAt;

    private Instant updatedAt;

    private String header;

    private TitledKeywords content;
}
