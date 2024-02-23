package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Resume;
import com.matheus.resumebuilder.repository.ResumeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Transactional
    public Resume create(Resume resume) {
        return this.resumeRepository.save(resume);
    }

    public List<Resume> findAll() {
        return this.resumeRepository.findAll();
    }

    public Resume findById(UUID id) {
        return this.resumeRepository.findById(id).orElse(null);
    }
}
