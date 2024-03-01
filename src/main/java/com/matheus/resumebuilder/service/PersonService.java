package com.matheus.resumebuilder.service;

import com.matheus.resumebuilder.model.Person;
import com.matheus.resumebuilder.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> findAll() {
        return this.personRepository.findAll();
    }

    public Person findById(final UUID id) {
        return this.personRepository.findById(id).orElse(null);
    }

    @Transactional
    public Person create(final Person person) {
        return this.personRepository.save(person);
    }

    @Transactional
    public Person update(final UUID id, Person person) {
        person.setId(id);
        return this.personRepository.save(person);
    }

    @Transactional
    public void deleteById(final UUID id) {
        this.personRepository.deleteById(id);
    }
}
