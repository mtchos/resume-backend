package com.matheus.resumebuilder.domain.entity.common.type;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class TitledKeywords {

    private String title;

    private List<String> keywords;
}
