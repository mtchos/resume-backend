package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Resume;
import com.matheus.resumebuilder.model.Sentence;
import com.matheus.resumebuilder.repository.SentenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class SentenceService {

    @Autowired
    private SentenceRepository sentenceRepository;

    @Autowired
    private ResumeService resumeService;

    public List<Sentence> findAll() {
        return this.sentenceRepository.findAll();
    }

    public Sentence findById(final UUID id) {
        return this.sentenceRepository.findById(id).orElse(null);
    }

    @Transactional
    public Sentence create(final UUID resumeId, final Sentence sentence) {
        final Resume resume = this.resumeService.findById(resumeId);
        sentence.setResume(resume);
        return this.sentenceRepository.save(sentence);
    }

    @Transactional
    public Sentence update(final UUID id, final Sentence sentence) {
        final UUID oldSentenceResumeId = this.findById(id).getResume().getId();
        final Resume resume = this.resumeService.findById(oldSentenceResumeId);
        sentence.setId(id);
        sentence.setResume(resume);
        return this.sentenceRepository.save(sentence);
    }

    @Transactional
    public void deleteById(final UUID id) {
        this.sentenceRepository.deleteById(id);
    }
}
