package com.matheus.resumebuilder.application.dto.section;

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
public class InfoDto {

    private UUID id;

    private UUID resumeId;

    private Instant createdAt;

    private Instant updatedAt;

    private String header;

    private String phone;

    private String location;

    private String email;

    private String linkedin;

    private String website;
}
