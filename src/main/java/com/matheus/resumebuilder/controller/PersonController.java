package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Person;
import com.matheus.resumebuilder.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return this.personService.findAll();
    }

    @GetMapping("{id}")
    public Person findById(@PathVariable final UUID id) {
        return this.personService.findById(id);
    }

    @PostMapping
    public Person create(@RequestBody final Person person) {
        return this.personService.create(person);
    }

    @PutMapping("{id}")
    public Person update(@PathVariable final UUID id, @RequestBody Person person) {
        return this.personService.update(id, person);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable final UUID id) {
        return ResponseEntity.ok().build();
    }
}
