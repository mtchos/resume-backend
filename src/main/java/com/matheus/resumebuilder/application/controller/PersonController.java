package com.matheus.resumebuilder.application.controller;

import com.matheus.resumebuilder.application.dto.PersonDto;
import com.matheus.resumebuilder.domain.entity.Person;
import com.matheus.resumebuilder.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.matheus.resumebuilder.application.converter.PersonConverter.convertToDto;
import static com.matheus.resumebuilder.application.converter.PersonConverter.convertToDtos;
import static com.matheus.resumebuilder.application.converter.PersonConverter.convertToEntity;
import static com.matheus.resumebuilder.application.converter.PersonConverter.convertToEntityForCreate;

@RestController
@RequestMapping("persons")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll() {
        List<Person> persons = this.personService.findAll();
        List<PersonDto> personsDtos = convertToDtos(persons);
        return ResponseEntity.ok(personsDtos);
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDto> findById(@PathVariable final UUID id) {
        Person person = this.personService.findById(id);
        PersonDto personDto = convertToDto(person);
        return ResponseEntity.ok(personDto);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PersonDto> create(@RequestBody final PersonDto personDto) {
        Person person = convertToEntityForCreate(personDto);
        Person personCreated = this.personService.create(person);
        PersonDto personCreatedDto = convertToDto(personCreated);
        return ResponseEntity.status(HttpStatus.CREATED).body(personCreatedDto);
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonDto> update(@RequestBody PersonDto personDto) {
        Person person = convertToEntity(personDto);
        Person personUpdated = this.personService.update(person);
        PersonDto personUpdatedDto = convertToDto(personUpdated);
        return ResponseEntity.ok(personUpdatedDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteById(@PathVariable final UUID id) {
        this.personService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
