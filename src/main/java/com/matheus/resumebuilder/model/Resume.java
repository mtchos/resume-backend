package com.matheus.resumebuilder.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonBackReference
    private Person person;

    @OneToMany(mappedBy = "resume", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Section> sections;

    private String name;

    private Boolean isActive;
}
