package com.matheus.resumebuilder.repository;

import com.matheus.resumebuilder.model.Sentence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SentenceRepository extends JpaRepository<Sentence, UUID> {

}
