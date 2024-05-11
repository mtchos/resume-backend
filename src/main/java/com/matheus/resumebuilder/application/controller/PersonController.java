package com.matheus.resumebuilder.application.controller;

import com.matheus.resumebuilder.domain.entity.Person;
import com.matheus.resumebuilder.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = this.personService.findAll();
        return ResponseEntity.ok(persons);
    }

    @GetMapping("{id}")
    public ResponseEntity<Person> findById(@PathVariable final UUID id) {
        Person person = this.personService.findById(id);
        return ResponseEntity.ok(person);
    }

    @PostMapping
    public ResponseEntity<Person> create(@RequestBody final Person person) {
        Person createdUser = this.personService.create(person);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("{id}")
    public ResponseEntity<Person> update(@PathVariable final UUID id, @RequestBody Person person) {
        Person personUpdated = this.personService.update(id, person);
        return ResponseEntity.ok(personUpdated);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable final UUID id) {
        this.personService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
