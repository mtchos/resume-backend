package com.matheus.resumebuilder.application.controller;

import com.matheus.resumebuilder.business.entity.Person;
import com.matheus.resumebuilder.business.entity.Resume;
import com.matheus.resumebuilder.business.service.PersonService;
import com.matheus.resumebuilder.business.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Resume> findAll() {
        return this.resumeService.findAll();
    }

    @GetMapping("{id}")
    public Resume findById(@PathVariable final UUID id) {
        return this.resumeService.findById(id);
    }

    @PostMapping
    public Resume create(@RequestBody final Resume resume) {
        Person person = personService.findById(resume.getPerson().getId());
        resume.setPerson(person);
        return this.resumeService.create(resume);
    }

    @PutMapping("{id}")
    public Resume update(@PathVariable final UUID id, @RequestBody final Resume resume) {
        return this.resumeService.update(id, resume);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable final UUID id) {
        this.resumeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
