package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Sentence;
import com.matheus.resumebuilder.repository.SentenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SentenceService {

    @Autowired
    private SentenceRepository sentenceRepository;

    public Sentence findById(UUID id) {
        return this.sentenceRepository.findById(id).orElse(null);
    }
}
