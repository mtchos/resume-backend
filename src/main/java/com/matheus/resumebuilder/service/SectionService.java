package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Section;
import com.matheus.resumebuilder.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> findAll() {
        return this.sectionRepository.findAll();
    }

    public Section findById(final UUID id) {
        return this.sectionRepository.findById(id).orElse(null);
    }

    public Section create(final Section section) {
        return this.sectionRepository.save(section);
    }

    public Section update(final UUID id, final Section section) {
        section.setId(id);
        return this.sectionRepository.save(section);
    }

    public void deleteById(final UUID id) {
        this.sectionRepository.deleteById(id);
    }
}
