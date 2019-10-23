package com.pw.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {

	List<T> getAll();

	T getOneById(ID id);

	Long create(T entity);
	
	Optional<T> findById(Long id);

	void update(ID id, T entity);

	void delete(ID id);
}