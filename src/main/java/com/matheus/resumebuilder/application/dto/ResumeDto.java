package com.matheus.resumebuilder.application.dto;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@With
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private UUID personId;

    private String code;

    private String header;

    private String role;

    private Boolean isActive;
}
