package com.matheus.resumebuilder.application.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@With
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private UUID id;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private List<UUID> resumesIds;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}