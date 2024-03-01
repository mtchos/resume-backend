package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Content;
import com.matheus.resumebuilder.repository.ContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class ContentService {

    @Autowired
    private ContentRepository contentRepository;

    public List<Content> findAll() {
        return this.contentRepository.findAll();
    }

    public Content findById(final UUID id) {
        return this.contentRepository.findById(id).orElse(null);
    }

    public Content create(final Content content) {
        return this.contentRepository.save(content);
    }

    public Content update(final UUID id, final Content content) {
        content.setId(id);
        return this.contentRepository.save(content);
    }

    public void deleteById(final UUID id) {
        this.contentRepository.deleteById(id);
    }
}
