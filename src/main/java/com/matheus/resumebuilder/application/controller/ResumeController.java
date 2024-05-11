package com.matheus.resumebuilder.application.controller;

import com.matheus.resumebuilder.domain.entity.Person;
import com.matheus.resumebuilder.domain.entity.resume.Resume;
import com.matheus.resumebuilder.domain.service.PersonService;
import com.matheus.resumebuilder.domain.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired PersonService personService;

    @GetMapping
    public ResponseEntity<List<Resume>> findAll() {
        List<Resume> resumes = resumeService.findAll();
        return ResponseEntity.ok(resumes);
    }

    @GetMapping("{personId}")
    public ResponseEntity<List<Resume>> findByPersonId(@PathVariable() UUID personId) {
        List<Resume> resumesByPersonId = resumeService.findByPersonId(personId);
        return ResponseEntity.ok(resumesByPersonId);
    }

    @GetMapping("{resumeId}")
    public ResponseEntity<Resume> findById(@PathVariable final UUID resumeId) {
        Resume resume = this.resumeService.findById(resumeId);
        return ResponseEntity.ok(resume);
    }

    @PostMapping
    public ResponseEntity<Resume> create(@RequestParam final UUID personId, @RequestBody final Resume resume) {
        Person person = this.personService.findById(personId);
        resume.setPerson(person);
        resume.setId(null);
        Resume resumeCreated = this.resumeService.create(resume);
        return ResponseEntity.status(HttpStatus.CREATED).body(resumeCreated);
    }

    @PutMapping
    public ResponseEntity<Resume> update(@RequestBody final Resume resume) {
        Resume resumeUpdated = this.resumeService.update(resume);
        return ResponseEntity.ok(resumeUpdated);
    }

    @DeleteMapping("{resumeId}")
    public ResponseEntity<?> deleteById(@PathVariable final UUID resumeId) {
        this.resumeService.deleteById(resumeId);
        return ResponseEntity.noContent().build();
    }
}
