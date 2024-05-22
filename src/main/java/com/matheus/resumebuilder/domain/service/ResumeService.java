package com.matheus.resumebuilder.domain.service;

import com.matheus.resumebuilder.database.ResumeDao;
import com.matheus.resumebuilder.database.PersonDao;
import com.matheus.resumebuilder.domain.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ResumeService {

    @Autowired
    private ResumeDao resumeDao;

    @Autowired
    private PersonDao personDao;

    public List<Resume> findAll() {
        return this.resumeDao.findAll();
    }

    public List<Resume> findByPersonId(UUID personId) {
        return this.resumeDao.findByPersonId(personId);
    }

    public Resume findById(final UUID resumeId) {
        return this.resumeDao.findById(resumeId).orElse(null);
    }

    @Transactional
    public Resume create(final Resume resume) {
        resume.setId(null);
        return this.resumeDao.save(resume);
    }

    @Transactional
    public Resume update(final Resume resume) {
        return this.resumeDao.save(resume);
    }

    @Transactional
    public void deleteById(final UUID resumeId) {
        this.resumeDao.deleteById(resumeId);
    }
}
