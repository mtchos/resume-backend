package com.matheus.resumebuilder.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.UUID;

@Getter
@With
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class ResumeDto {

    private UUID id;

    private String createdAt;

    private String updatedAt;

    private UUID personId;

    private String code;

    private String header;

    private String role;

    private Boolean isActive;
}
