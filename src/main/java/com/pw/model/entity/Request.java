package com.pw.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "requests")
public class Request {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

private String description;
private String state;
private String date;

private int number;

private double price_unit;
	@ManyToMany(mappedBy = "categories")
	private List<Book> books;

	public Request() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

}