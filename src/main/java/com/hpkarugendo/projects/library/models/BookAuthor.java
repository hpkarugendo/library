package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class BookAuthor {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 100)
	private String name;
	private char sex;
	@ManyToOne
	private Country country;
	@OneToMany(mappedBy = "author")
	private List<Book> books;

	public BookAuthor() {
	}

	public BookAuthor(String name, char sex, Country country) {
		this.name = name;
		this.sex = sex;
		this.country = country;
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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "BookAuthor [id=" + id + ", name=" + name + ", sex=" + sex + ", country=" + country.getName() + "]";
	}

}
