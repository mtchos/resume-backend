package com.matheus.resumebuilder.application.converter;

import com.matheus.resumebuilder.application.dto.ResumeDto;
import com.matheus.resumebuilder.domain.entity.Person;
import com.matheus.resumebuilder.domain.entity.Resume;
import com.matheus.resumebuilder.domain.service.PersonService;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.UUID;

@Configuration
public class ResumeConverter {

    public static Resume convertToEntity(ResumeDto resumeDto) {
        UUID resumeId = resumeDto.getId();
        Person person = new PersonService().findById(resumeId);
        return new Resume()
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
