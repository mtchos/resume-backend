package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Sentence;
import com.matheus.resumebuilder.service.SentenceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        return this.sentenceService.findAll();
    }

    @GetMapping("{id}")
    public Sentence findById(@PathVariable final UUID id) {
        return this.sentenceService.findById(id);
    }

    @PostMapping("{resumeId}")
    public Sentence create(@PathVariable final UUID resumeId, @RequestBody final Sentence sentence) {
        return this.sentenceService.create(resumeId, sentence);
    }

    @PutMapping("{id}")
    public Sentence update(@PathVariable final UUID id, @RequestBody final Sentence sentence) {
        return this.sentenceService.update(id, sentence);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable final UUID id) {
        this.sentenceService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
