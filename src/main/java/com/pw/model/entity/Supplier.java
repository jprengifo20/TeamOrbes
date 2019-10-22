package com.pw.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.Type;

@Entity
@Table(name="suppliers")
public class Supplier {

	@Id
	@Column(name="supplier_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String enterprise;

	private Long ruc;
	@NotEmpty
	private String product;

	private Long phone;
	
	@Lob
	@Type(type = "org.hibernate.type.TextType")
	private String deleteDetails;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEnterprise() {
		return enterprise;
	}
	public void setEnterprise(String enterprise) {
		this.enterprise = enterprise;
	}
	public Long getRuc() {
		return ruc;
	}
	public void setRuc(Long ruc) {
		this.ruc = ruc;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public String getDeleteDetails() {
		return deleteDetails;
	}
	public void setDeleteDetails(String deleteDetails) {
		this.deleteDetails = deleteDetails;
	}
	
}
