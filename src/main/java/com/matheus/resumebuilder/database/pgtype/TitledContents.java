package com.matheus.resumebuilder.database.pgtype;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class TitledContents {

    private String title;

    private List<String> contents;
}
