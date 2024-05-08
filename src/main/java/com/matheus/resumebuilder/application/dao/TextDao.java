package com.matheus.resumebuilder.application.dao;

import com.matheus.resumebuilder.business.entity.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TextDao extends JpaRepository<Text, UUID> {

}
