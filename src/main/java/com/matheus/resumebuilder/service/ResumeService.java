package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Resume;
import com.matheus.resumebuilder.repository.ResumeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;


    public List<Resume> findAll() {
        return this.resumeRepository.findAll();
    }

    public Resume findById(UUID id) {
        return this.resumeRepository.findById(id).orElse(null);
    }

    @Transactional
    public Resume create(Resume resume) {
        resume.setId(null);
        return this.resumeRepository.save(resume);
    }

    @Transactional
    public Resume update(UUID id, Resume resume) {
        resume.setId(id);
        return this.resumeRepository.save(resume);
    }

    @Transactional
    public void deleteById(UUID id) {
        this.resumeRepository.deleteById(id);
    }
}
