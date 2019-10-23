package com.pw.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pw.model.entity.Request;



@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

	@Query("select m from Request m where m.id like %?1%")
	List<Request> fetchRequestById(Long id);
	
}
