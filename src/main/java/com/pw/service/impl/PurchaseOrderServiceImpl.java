package com.pw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.model.entity.PurchaseOrder;
import com.pw.model.repository.PurchaseOrderRepository;
import com.pw.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
	
	@Autowired
	private PurchaseOrderRepository purchaseorderRepository;

	@Override
	public List<PurchaseOrder> getAll() {
		// TODO Auto-generated method stub
		return purchaseorderRepository.findAll();
	}

	@Override
	public PurchaseOrder getOneById(Long id) {
		// TODO Auto-generated method stub
		return purchaseorderRepository.findById(id).orElseThrow(() -> new RuntimeException("PurchaseOrder not found"));
	}

	@Override
	public Long create(PurchaseOrder entity) {
		// TODO Auto-generated method stub
		purchaseorderRepository.save(entity);
		return entity.getId();
	}

	@Override
	public void update(Long id, PurchaseOrder entity) {
		// TODO Auto-generated method stub
		PurchaseOrder currentIncident= getOneById(id);
		currentIncident.setSuppliers(entity.getSuppliers());
		currentIncident.setDate(entity.getDate());
		currentIncident.setProduct(entity.getProduct());
		currentIncident.setResponsible(entity.getResponsible());
		currentIncident.setDetail(entity.getDetail());
		purchaseorderRepository.save(currentIncident);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		purchaseorderRepository.deleteById(id); 
	}

	@Override
	public Optional<PurchaseOrder> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	} 
	
	
}
