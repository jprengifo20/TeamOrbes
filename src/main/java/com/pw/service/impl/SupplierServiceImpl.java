package com.pw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.model.entity.Supplier;
import com.pw.model.repository.SupplierRepository;
import com.pw.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public List<Supplier> getAll()
	{
		return supplierRepository.findAll();
	}
	
	@Override
	public Supplier getOneById(Long id)
	{
		return supplierRepository.findById(id).orElseThrow(()->new RuntimeException("Proveedor no encontrado!"));
	}
	
	@Override
	public Long create(Supplier entity)
	{
		supplierRepository.save(entity);
		return entity.getId();
	}
	
	@Override
	public void update(Long id, Supplier entity)
	{
		Supplier currentSupplier=getOneById(id);
		currentSupplier.setEnterprise(entity.getEnterprise());
		currentSupplier.setRuc(entity.getRuc());
		currentSupplier.setProduct(entity.getProduct());
		currentSupplier.setPhone(entity.getPhone());
		supplierRepository.save(currentSupplier);
	}
	
	@Override
	public void delete(Long id)
	{
		supplierRepository.deleteById(id);
	}

	@Override
	public Optional<Supplier> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
