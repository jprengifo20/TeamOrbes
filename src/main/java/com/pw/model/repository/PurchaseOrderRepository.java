package com.pw.model.repository;

/*org.hibernate.type.TextTypepackage com.hampcode.model.repository;*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pw.model.entity.PurchaseOrder;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

}

