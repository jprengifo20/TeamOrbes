package com.pw.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pw.model.entity.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
