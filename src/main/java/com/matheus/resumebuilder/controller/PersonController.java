package com.matheus.resumebuilder.controller;

import com.matheus.resumebuilder.model.Person;
import com.matheus.resumebuilder.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public List<Person> findAll() {
        return this.personService.findAll();
    }

    @PostMapping
    public Person create(@RequestBody final Person person) {
        person.setId(person.getId());
        return this.personService.create(person);
    }
}
