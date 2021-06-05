package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Music {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 35)
	private String title;
	@ManyToMany(mappedBy = "songs")
	private List<MusicArtist> artists;
	@ManyToOne
	private MusicAlbum album;
	@ManyToOne
	private MusicGenre genre;
	private int year;
	private int runtime;

	public Music() {
	}

	public Music(String title, MusicAlbum album, MusicGenre genre, int year, int runtime) {
		this.title = title;
		this.album = album;
		this.genre = genre;
		this.year = year;
		this.runtime = runtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<MusicArtist> getArtists() {
		return artists;
	}

	public void setArtists(List<MusicArtist> artists) {
		this.artists = artists;
	}

	public MusicAlbum getAlbum() {
		return album;
	}

	public void setAlbum(MusicAlbum album) {
		this.album = album;
	}

	public MusicGenre getGenre() {
		return genre;
	}

	public void setGenre(MusicGenre genre) {
		this.genre = genre;
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

	@Override
	public String toString() {
		return "Music [id=" + id + ", title=" + title + ", album=" + album.getName() + ", genre=" + genre.getName()
				+ ", year=" + year + ", runtime=" + runtime + "]";
	}

}
