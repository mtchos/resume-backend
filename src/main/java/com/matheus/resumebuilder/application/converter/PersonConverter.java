package com.matheus.resumebuilder.application.converter;

import com.matheus.resumebuilder.application.dto.PersonDto;
import com.matheus.resumebuilder.domain.entity.Person;
import com.matheus.resumebuilder.domain.entity.Resume;
import com.matheus.resumebuilder.domain.service.ResumeService;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class PersonConverter {

    public static Person convertToEntity(PersonDto personDto) {
        UUID personId = personDto.getId();
        List<Resume> resumes = new ResumeService().findByPersonId(personId);
        return new Person()
                .withId(personId)
                .withResumes(resumes)
                .withUsername(personDto.getUsername())
                .withFirstName(personDto.getFirstName())
                .withLastName(personDto.getLastName())
                .withEmail(personDto.getEmail());
    }

    public static Person convertToEntityForCreate(PersonDto personDto) {
        return new Person()
                .withId(UUID.randomUUID())
                .withUsername(personDto.getUsername())
                .withFirstName(personDto.getFirstName())
                .withLastName(personDto.getLastName())
                .withEmail(personDto.getEmail())
                .withPassword(personDto.getPassword());
    }

    public static List<Person> convertToEntities(List<PersonDto> personDtos) {
        return personDtos
                .stream()
                .map(PersonConverter::convertToEntity)
                .toList();
    }

    public static PersonDto convertToDto(Person person) {
        List<UUID> resumesIds = person
                .getResumes()
                .stream()
                .map(Resume::getId)
                .toList();
        return new PersonDto()
                .withId(person.getId())
                .withCreatedAt(person.getCreatedAt().toString())
                .withUpdatedAt(person.getUpdatedAt().toString())
                .withResumesIds(resumesIds)
                .withUsername(person.getUsername())
                .withFirstName(person.getFirstName())
                .withLastName(person.getLastName())
                .withEmail(person.getEmail());
    }

    public static List<PersonDto> convertToDtos(List<Person> persons) {
        return persons
                .stream()
                .map(PersonConverter::convertToDto)
                .toList();
    }
}
