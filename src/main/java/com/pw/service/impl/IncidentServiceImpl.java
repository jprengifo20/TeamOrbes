package com.pw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.model.entity.Incident;
import com.pw.model.repository.IncidentRepository;
import com.pw.service.IncidentService;

@Service
public class IncidentServiceImpl implements IncidentService {
	
	@Autowired
	private IncidentRepository incidentRepository;

	@Override
	public List<Incident> getAll() {
		// TODO Auto-generated method stub
		return incidentRepository.findAll();
	}

	@Override
	public Incident getOneById(Long id) {
		// TODO Auto-generated method stub
		return incidentRepository.findById(id).orElseThrow(() -> new RuntimeException("Incident not found"));
	}

	@Override
	public Long create(Incident entity) {
		// TODO Auto-generated method stub
		incidentRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, Incident entity) {
		// TODO Auto-generated method stub
		Incident currentIncident= getOneById(id);
		currentIncident.setSuppliers(entity.getSuppliers());
		currentIncident.setDate(entity.getDate());
		currentIncident.setGravity(entity.getGravity());
		currentIncident.setObservations(entity.getObservations());
		incidentRepository.save(currentIncident);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		incidentRepository.deleteById(id); 
	}

	@Override
	public Optional<Incident> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
}
