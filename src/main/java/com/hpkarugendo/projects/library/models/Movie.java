package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 35)
	private String image;
	@Column(length = 30)
	private String title;
	@Column(columnDefinition = "TEXT")
	private String synopsis;
	@ManyToOne
	private MovieDirector director;
	@ManyToMany(mappedBy = "movies")
	private List<MovieActor> actors;
	@ManyToOne
	private Country country;
	private int year;
	private int runtime;
	@ManyToMany(mappedBy = "movies")
	private List<MovieGenre> genres;

	public Movie() {
	}

	public Movie(String title, String synopsis, MovieDirector director, Country country, int year, int runtime) {
		this.title = title;
		this.synopsis = synopsis;
		this.director = director;
		this.country = country;
		this.year = year;
		this.runtime = runtime;
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

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public MovieDirector getDirector() {
		return director;
	}

	public void setDirector(MovieDirector director) {
		this.director = director;
	}

	public List<MovieActor> getActors() {
		return actors;
	}

	public void setActors(List<MovieActor> actors) {
		this.actors = actors;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public List<MovieGenre> getGenres() {
		return genres;
	}

	public void setGenres(List<MovieGenre> genres) {
		this.genres = genres;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", image=" + image + ", title=" + title + ", synopsis=" + synopsis + ", director="
				+ director.getName() + ", country=" + country.getName() + ", year=" + year + ", runtime=" + runtime
				+ ", genres=" + genres + "]";
	}

}
