package com.matheus.resumebuilder.business.service;

import com.matheus.resumebuilder.application.dao.TextDao;
import com.matheus.resumebuilder.business.entity.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class TextService {

    @Autowired
    private TextDao textDao;

    public List<Text> findAll() {
        return this.textDao.findAll();
    }

    public Text findById(final UUID id) {
        return this.textDao.findById(id).orElse(null);
    }

    public Text create(final Text text) {
        return this.textDao.save(text);
    }

    public Text update(final UUID id, final Text text) {
        text.setId(id);
        return this.textDao.save(text);
    }

    public void deleteById(final UUID id) {
        this.textDao.deleteById(id);
    }
}
