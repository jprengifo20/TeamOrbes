package com.pw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pw.model.entity.Category;
import com.pw.model.repository.CategoryRepository;
import com.pw.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getOneById(Long id) {
		return categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category Not Found!"));
	}

	@Override
	public Long create(Category entity) {
		categoryRepository.save(entity);
        return entity.getId();
	}

	@Override
	public void update(Long id, Category entity) {
		Category currentCategory = getOneById(id);
		currentCategory.setName(entity.getName());
		categoryRepository.save(currentCategory);
	}

	@Override
	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

}
