package com.matheus.resumebuilder.database.resume.section;

import com.matheus.resumebuilder.domain.entity.resume.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InfoDao extends JpaRepository<Resume, UUID> {

}
