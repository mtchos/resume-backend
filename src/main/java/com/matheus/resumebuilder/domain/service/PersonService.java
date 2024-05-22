package com.matheus.resumebuilder.domain.service;

import com.matheus.resumebuilder.database.PersonDao;
import com.matheus.resumebuilder.domain.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonDao personDao;

    public List<Person> findAll() {
        return this.personDao.findAll();
    }

    public Person findById(final UUID id) {
        return this.personDao.findById(id).orElse(null);
    }

    @Transactional
    public Person create(final Person person) {
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());
        return this.personDao.save(person);
    }

    @Transactional
    public Person update(Person person) {
        return this.personDao.save(person);
    }

    @Transactional
    public void deleteById(final UUID id) {
        this.personDao.deleteById(id);
    }
}
