package com.matheus.resumebuilder.database.section;

import com.matheus.resumebuilder.domain.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SkillDao extends JpaRepository<Resume, UUID> {

}
