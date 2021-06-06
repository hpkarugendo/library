package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookGenre {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 30)
	private String name;
	@OneToMany(mappedBy = "genre")
	private List<Book> books;

	public BookGenre() {
	}

	public BookGenre(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "BookGenre [id=" + id + ", name=" + name + "]";
	}

}
