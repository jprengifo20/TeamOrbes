package com.pw.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.model.entity.Request;
import com.pw.model.repository.RequestRepository;
import com.pw.service.RequestService;

@Service
public class RequestServiceImpl implements RequestService {

	@Autowired
	private RequestRepository requestRepository;

	@Override
	public List<Request> getAll() {
		return requestRepository.findAll();
	}

	@Override
	public Request getOneById(Long id) {
		return requestRepository.findById(id).orElseThrow(() -> new RuntimeException("Request Not Found!"));
	}

	@Override
	public Long create(Request entity) {
		requestRepository.save(entity);
        return entity.getId();
	}

	@Override
	public void update(Long id, Request entity) {
		Request currentRequest = getOneById(id);
		currentRequest.setArea(entity.getArea());
		currentRequest.setProduct(entity.getProduct());
		currentRequest.setDescription(entity.getDescription());
		currentRequest.setQuantity(entity.getQuantity());
		currentRequest.setState(entity.getState());
		currentRequest.setDate(entity.getDate());
		currentRequest.setUnit_price(entity.getUnit_price());

		requestRepository.save(currentRequest);
	}

	@Override
	public void delete(Long id) {
		requestRepository.deleteById(id);
	}

	@Override
	public Optional<Request> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
}
