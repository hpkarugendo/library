package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class MovieGenre {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 100)
	private String name;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "movie_genres", joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "movie_genre_id", referencedColumnName = "id"))
	private List<Movie> movies;

	public MovieGenre() {
	}

	public MovieGenre(String name) {
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

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "MovieGenre [id=" + id + ", name=" + name + "]";
	}

}
