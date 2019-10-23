package com.pw.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pw.model.entity.Product;
import com.pw.model.repository.ProductRepository;
import com.pw.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product getOneById(Long id) {
		return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found!"));

	}

	@Override
	public Long create(Product entity) {
		productRepository.save(entity);
        return entity.getId();
	}

	@Override
	public void update(Long id, Product entity) {
		Product currentProduct = getOneById(id);
		currentProduct.setName(entity.getName());
		currentProduct.setPrice(entity.getPrice());
		currentProduct.setStock(entity.getStock());
		productRepository.save(currentProduct);
	}

	@Override
	public void delete(Long id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public Optional<Product> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}