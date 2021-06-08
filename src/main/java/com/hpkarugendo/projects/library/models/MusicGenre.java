package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class MusicGenre {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 100)
	private String name;
	@OneToMany(mappedBy = "genre")
	private List<Music> songs;

	public MusicGenre() {
	}

	public MusicGenre(String name) {
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

	public List<Music> getSongs() {
		return songs;
	}

	public void setSongs(List<Music> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "MusicGenre [id=" + id + ", name=" + name + "]";
	}

}
