package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Text;
import com.matheus.resumebuilder.repository.TextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TextService {

    @Autowired
    private TextRepository textRepository;

    public List<Text> findAll() {
        return this.textRepository.findAll();
    }

    public Text findById(final UUID id) {
        return this.textRepository.findById(id).orElse(null);
    }

    public Text create(final Text text) {
        return this.textRepository.save(text);
    }

    public Text update(final UUID id, final Text text) {
        text.setId(id);
        return this.textRepository.save(text);
    }

    public void deleteById(final UUID id) {
        this.textRepository.deleteById(id);
    }
}
