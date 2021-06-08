package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MusicAlbum {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 100)
	private String name;
	@OneToMany(mappedBy = "album")
	private List<Music> songs;
	private int year;

	public MusicAlbum() {
	}

	public MusicAlbum(String name, int year) {
		this.name = name;
		this.year = year;
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

	public List<Music> getSongs() {
		return songs;
	}

	public void setSongs(List<Music> songs) {
		this.songs = songs;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "MusicAlbum [id=" + id + ", name=" + name + ", year=" + year + "]";
	}

}
