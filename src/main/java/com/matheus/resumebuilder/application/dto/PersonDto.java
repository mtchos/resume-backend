package com.matheus.resumebuilder.application.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;
import java.util.UUID;

@Getter
@With
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private UUID id;

    private String createdAt;

    private String updatedAt;

    private List<UUID> resumesIds;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String password;
}