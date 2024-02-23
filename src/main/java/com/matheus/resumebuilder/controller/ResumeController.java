package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Resume;
import com.matheus.resumebuilder.model.Sentence;
import com.matheus.resumebuilder.service.ResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("resume")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

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
        List<Sentence> sentences = resume.getSentences().stream().peek(sentence -> sentence.setResume(resume)).toList();
        System.out.println(sentences);
        resume.setSentences(sentences);
        return this.resumeService.create(resume);
    }
}
