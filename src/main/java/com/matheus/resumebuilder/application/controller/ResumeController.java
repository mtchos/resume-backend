package com.matheus.resumebuilder.application.controller;

import com.matheus.resumebuilder.application.dto.ResumeDto;
import com.matheus.resumebuilder.domain.entity.Resume;
import com.matheus.resumebuilder.domain.service.PersonService;
import com.matheus.resumebuilder.domain.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import static com.matheus.resumebuilder.application.converter.ResumeConverter.convertToDto;
import static com.matheus.resumebuilder.application.converter.ResumeConverter.convertToDtos;
import static com.matheus.resumebuilder.application.converter.ResumeConverter.convertToEntity;
import static com.matheus.resumebuilder.application.converter.ResumeConverter.convertToEntityForCreate;

@RestController
@RequestMapping("resumes")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<ResumeDto>> findAll() {
        List<Resume> resumes = this.resumeService.findAll();
        List<ResumeDto> resumesDtos = convertToDtos(resumes);
        return ResponseEntity.ok(resumesDtos);
    }

    @GetMapping("{personId}")
    public ResponseEntity<List<ResumeDto>> findByPersonId(@PathVariable UUID personId) {
        List<Resume> resumes = this.resumeService.findByPersonId(personId);
        List<ResumeDto> resumesDtos = convertToDtos(resumes);
        return ResponseEntity.ok(resumesDtos);
    }

    @GetMapping("{resumeId}")
    public ResponseEntity<ResumeDto> findById(@PathVariable final UUID resumeId) {
        Resume resume = this.resumeService.findById(resumeId);
        ResumeDto resumeDto = convertToDto(resume);
        return ResponseEntity.ok(resumeDto);
    }

    @PostMapping
    public ResponseEntity<ResumeDto> create(@RequestBody final ResumeDto resumeDto) {
        Resume resume = convertToEntityForCreate(resumeDto);
        Resume resumeCreated = this.resumeService.create(resume);
        ResumeDto resumeDtoCreated = convertToDto(resumeCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(resumeDtoCreated);
    }

    @PutMapping
    public ResponseEntity<ResumeDto> update(@RequestBody final ResumeDto resumeDto) {
        Resume resume = convertToEntity(resumeDto);
        Resume resumeUpdated = this.resumeService.update(resume);
        ResumeDto resumeDtoUpdated = convertToDto(resumeUpdated);
        return ResponseEntity.ok(resumeDtoUpdated);
    }

    @DeleteMapping("{resumeId}")
    public ResponseEntity<?> deleteById(@PathVariable final UUID resumeId) {
        this.resumeService.deleteById(resumeId);
        return ResponseEntity.noContent().build();
    }
}
