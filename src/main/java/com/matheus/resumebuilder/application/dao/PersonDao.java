package com.matheus.resumebuilder.application.dao;

import com.matheus.resumebuilder.business.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonDao extends JpaRepository<Person, UUID> {

}
