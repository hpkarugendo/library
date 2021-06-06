package com.hpkarugendo.projects.library.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 35)
	private String image;
	@Column(length = 50)
	private String title;
	@ManyToOne
	private BookAuthor author;
	private int pages;
	@Column(columnDefinition = "TEXT")
	private String synopsis;
	private int year;
	@ManyToOne
	private BookGenre genre;
	
	public Book() {
	}

	public Book(String title, BookAuthor author, int pages, String synopsis, int year, BookGenre genre) {
		this.title = title;
		this.author = author;
		this.pages = pages;
		this.synopsis = synopsis;
		this.year = year;
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BookAuthor getAuthor() {
		return author;
	}

	public void setAuthor(BookAuthor author) {
		this.author = author;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public BookGenre getGenre() {
		return genre;
	}

	public void setGenre(BookGenre genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", image=" + image + ", title=" + title + ", author=" + author.getName() + ", pages=" + pages
				+ ", synopsis=" + synopsis + ", year=" + year + ", genre=" + genre.getName() + "]";
	}
	

}
