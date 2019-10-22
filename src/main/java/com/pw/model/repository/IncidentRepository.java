package com.pw.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pw.model.entity.Incident;

@Repository
public interface IncidentRepository extends JpaRepository<Incident, Long> {

}

