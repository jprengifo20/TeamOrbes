package com.pw.model.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "purchaseRequests")
public class Request {
	
	@Id
	@Column(name="req_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 Long id;
	
	@NotEmpty
	private String area;
	
	@NotEmpty
	private String product;
	
	
	
	@NotEmpty
	private String description;
	
	
	private Long quantity;
	
	@NotEmpty
	private String state;
	
	@NotEmpty
	private String date;

	@Column(name="unit_price",nullable = false)
	private double unit_price;
	
	public Request()
	{
		
	}
	


	//Setter and Getters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}



	public String getProduct() {
		return product;
	}



	public void setProduct(String product) {
		this.product = product;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public double getUnit_price() {
		return unit_price;
	}



	public void setUnit_price(double unit_price) {
		this.unit_price = unit_price;
	}



	public Long getQuantity() {
		return quantity;
	}



	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	
}