package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Text;
import com.matheus.resumebuilder.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("texts")
public class TextController {

    @Autowired
    private TextService textService;

    @GetMapping
    public List<Text> findAll() {
        return this.textService.findAll();
    }

    @GetMapping("{id}")
    public Text findById(@PathVariable final UUID id) {
        return this.textService.findById(id);
    }

    @PostMapping
    public Text create(final Text text) {
        return this.textService.create(text);
    }

    @PutMapping
    public Text update(final UUID id, final Text text) {
        return this.textService.update(id, text);
    }

    @DeleteMapping
    public ResponseEntity<?> deleteById(final UUID id) {
        this.textService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
