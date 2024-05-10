package com.matheus.resumebuilder.domain.service;

import com.matheus.resumebuilder.database.resume.ResumeDao;
import com.matheus.resumebuilder.domain.entity.resume.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ResumeService {

    @Autowired
    private ResumeDao resumeDao;


    public List<Resume> findAll() {
        return this.resumeDao.findAll();
    }

    public Resume findById(final UUID id) {
        return this.resumeDao.findById(id).orElse(null);
    }

    @Transactional
    public Resume create(final Resume resume) {
        resume.setId(null);
        return this.resumeDao.save(resume);
    }

    @Transactional
    public Resume update(final UUID id, final Resume resume) {
        resume.setId(id);
        return this.resumeDao.save(resume);
    }

    @Transactional
    public void deleteById(final UUID id) {
        this.resumeDao.deleteById(id);
    }
}
