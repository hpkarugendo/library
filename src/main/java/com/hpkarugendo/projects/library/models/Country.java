package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Country {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 100)
	private String name;
	@Column(length = 2)
	private String code;
	@OneToMany(mappedBy = "country")
	private List<BookAuthor> authors;
	@OneToMany(mappedBy = "country")
	private List<Movie> movies;
	@OneToMany(mappedBy = "country")
	private List<MovieDirector> directors;
	@OneToMany(mappedBy = "country")
	private List<MovieActor> actors;
	@OneToMany(mappedBy = "country")
	private List<MusicArtist> artists;

	public Country() {
	}

	public Country(String name, String code) {
		this.name = name;
		this.code = code;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<BookAuthor> getAuthors() {
		return authors;
	}

	public void setAuthors(List<BookAuthor> authors) {
		this.authors = authors;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	public List<MovieDirector> getDirectors() {
		return directors;
	}

	public void setDirectors(List<MovieDirector> directors) {
		this.directors = directors;
	}

	public List<MovieActor> getActors() {
		return actors;
	}

	public void setActors(List<MovieActor> actors) {
		this.actors = actors;
	}

	public List<MusicArtist> getArtists() {
		return artists;
	}

	public void setArtists(List<MusicArtist> artists) {
		this.artists = artists;
	}

	@Override
	public String toString() {
		return "Country [id=" + id + ", name=" + name + ", code=" + code + "]";
	}

}
