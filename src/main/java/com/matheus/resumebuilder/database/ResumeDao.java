package com.matheus.resumebuilder.database;

import com.matheus.resumebuilder.domain.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ResumeDao extends JpaRepository<Resume, UUID> {

    List<Resume> findByPersonId(UUID personId);
}
