package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Content;
import com.matheus.resumebuilder.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("contents")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @GetMapping
    public List<Content> findAll() {
        return this.contentService.findAll();
    }

    @GetMapping("{id}")
    public Content findById(@PathVariable final UUID id) {
        return this.contentService.findById(id);
    }

    @PostMapping
    public Content create(final Content content) {
        return this.contentService.create(content);
    }

    @PutMapping
    public Content update(final UUID id, final Content content) {
        return this.contentService.update(id, content);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(final UUID id) {
        this.contentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
