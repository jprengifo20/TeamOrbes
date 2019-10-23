package com.pw.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "purchaseorders")
public class PurchaseOrder {

	@Id
	@Column(name = "purchaseorder_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	
	

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getResponsible() {
		return responsible;
	}

	public void setResponsible(String responsible) {
		this.responsible = responsible;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}





	@NotEmpty
	private String product;

	@NotEmpty
	private String responsible;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "purchaseorders_supplier", 
				joinColumns = { @JoinColumn(name = "purchaseorder_id") }, 
				inverseJoinColumns = {@JoinColumn(name = "supplier_id") 
			})
	private List<Supplier> suppliers = new ArrayList<>();

	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy")
	private Date date;

	@Lob
	@NotEmpty
	@Type(type = "org.hibernate.type.TextType")
	private String detail;
}