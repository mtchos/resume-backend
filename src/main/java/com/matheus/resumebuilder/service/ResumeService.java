package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Resume;

import org.springframework.stereotype.Service;

@Service
public class ResumeService {

    public Resume create(Resume resume) {
        return resume;
    }
}
