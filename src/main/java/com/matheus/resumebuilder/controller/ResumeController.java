package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Resume;
import com.matheus.resumebuilder.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController(value = "resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @GetMapping
    public List<Resume> findAll() {
        return List.of(new Resume("Test"));
    }

    @PostMapping
    public Resume create(@RequestBody final Resume resume) {
        return this.resumeService.create(resume);
    }
}
