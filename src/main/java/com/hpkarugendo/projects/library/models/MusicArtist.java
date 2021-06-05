package com.hpkarugendo.projects.library.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class MusicArtist {
	@Id
	@GeneratedValue
	private int id;
	@Column(length = 30)
	private String name;
	private char sex;
	@ManyToOne
	private Country country;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "music_artists", joinColumns = @JoinColumn(name = "music_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "music_artist_id", referencedColumnName = "id"))
	private List<Music> songs;

	public MusicArtist() {
	}

	public MusicArtist(String name, char sex, Country country) {
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

	public List<Music> getSongs() {
		return songs;
	}

	public void setSongs(List<Music> songs) {
		this.songs = songs;
	}

	@Override
	public String toString() {
		return "MusicArtist [id=" + id + ", name=" + name + ", sex=" + sex + ", country=" + country.getName() + "]";
	}

}
