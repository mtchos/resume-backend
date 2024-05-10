package com.matheus.resumebuilder.database.user;

import com.matheus.resumebuilder.domain.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PersonDao extends JpaRepository<Person, UUID> {

}
