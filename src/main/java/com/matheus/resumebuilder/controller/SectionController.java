package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Section;
import com.matheus.resumebuilder.service.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("section")
public class SectionController {

    @Autowired
    private SectionService sectionService;

    @GetMapping
    public List<Section> findAll() {
        return this.sectionService.findAll();
    }

    @GetMapping("{id}")
    public Section findById(@PathVariable final UUID id) {
        return this.sectionService.findById(id);
    }

    @PostMapping
    public Section create(@RequestBody final Section section) {
        return this.sectionService.create(section);
    }

    @PutMapping("{id}")
    public Section update(@PathVariable final UUID id, @RequestBody final Section section) {
        return this.sectionService.update(id, section);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable final UUID id) {
        this.sectionService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
