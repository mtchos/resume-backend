package com.matheus.resumebuilder.business.service;

import com.matheus.resumebuilder.application.dao.SectionDao;
import com.matheus.resumebuilder.business.entity.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SectionService {

    @Autowired
    private SectionDao sectionDao;

    public List<Section> findAll() {
        return this.sectionDao.findAll();
    }

    public Section findById(final UUID id) {
        return this.sectionDao.findById(id).orElse(null);
    }

    public Section create(final Section section) {
        return this.sectionDao.save(section);
    }

    public Section update(final UUID id, final Section section) {
        section.setId(id);
        return this.sectionDao.save(section);
    }

    public void deleteById(final UUID id) {
        this.sectionDao.deleteById(id);
    }
}
