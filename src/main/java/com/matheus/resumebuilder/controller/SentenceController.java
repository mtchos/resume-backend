package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Sentence;
import com.matheus.resumebuilder.service.SentenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("sentence")
public class SentenceController {

    @Autowired
    private SentenceService sentenceService;

    @GetMapping
    public List<Sentence> findAll() {
        return List.of();
    }

    @GetMapping("{id}")
    public Sentence findById(@PathVariable final UUID id) {
        return this.sentenceService.findById(id);
    }
}
