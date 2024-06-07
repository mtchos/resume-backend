package com.matheus.resumebuilder.application.converter;

import com.matheus.resumebuilder.application.dto.ResumeDto;
import com.matheus.resumebuilder.domain.entity.Person;
import com.matheus.resumebuilder.domain.entity.Resume;
import com.matheus.resumebuilder.domain.service.PersonService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class ResumeConverter {

    @Autowired
    private PersonService personService;

    private static PersonService staticPersonService;

    @PostConstruct
    public void init() {
        staticPersonService = personService;
    }

    public static Resume convertToEntity(ResumeDto resumeDto) {
        UUID personId = resumeDto.getPersonId();
        Person person = ResumeConverter.staticPersonService.findById(personId);
        return new Resume()
                .withId(resumeDto.getId())
                .withPerson(person)
                .withCode(resumeDto.getCode())
                .withHeader(resumeDto.getHeader())
                .withRole(resumeDto.getRole())
                .withIsActive(resumeDto.getIsActive());
    }

    public static Resume convertToEntityForCreate(ResumeDto resumeDto) {
        UUID personId = resumeDto.getPersonId();
        Person person = ResumeConverter.staticPersonService.findById(personId);
        return new Resume()
                .withId(UUID.randomUUID())
                .withPerson(person)
                .withCode(resumeDto.getCode())
                .withHeader(resumeDto.getHeader())
                .withRole(resumeDto.getRole())
                .withIsActive(resumeDto.getIsActive());
    }

    public static List<Resume> convertToEntities(List<ResumeDto> resumesDtos) {
        return resumesDtos
                .stream()
                .map(ResumeConverter::convertToEntity)
                .toList();
    }

    public static ResumeDto convertToDto(Resume resume) {
        UUID personId = resume.getPerson().getId();
        return new ResumeDto()
                .withId(resume.getId())
                .withCreatedAt(resume.getCreatedAt().toString())
                .withUpdatedAt(resume.getUpdatedAt().toString())
                .withPersonId(personId)
                .withCode(resume.getCode())
                .withHeader(resume.getHeader())
                .withRole(resume.getRole())
                .withIsActive(resume.getIsActive());
    }

    public static List<ResumeDto> convertToDtos(List<Resume> resumes) {
        return resumes
                .stream()
                .map(ResumeConverter::convertToDto)
                .toList();
    }
}
