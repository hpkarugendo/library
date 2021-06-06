package com.hpkarugendo.projects.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.library.models.MusicGenre;
import com.hpkarugendo.projects.library.repositories.MusicGenreRepository;

@Service
public class MusicGenreService {
	private MusicGenreRepository mgRepo;
	
	public MusicGenreService(MusicGenreRepository mgRepo) {
		super();
		this.mgRepo = mgRepo;
	}

	public boolean saveGenre(MusicGenre g) {
		boolean ans = false;
		
		try {
			mgRepo.save(g);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR SAVING MUSIC GENRE!");
		}
		
		return ans;
	}
	
	public List<MusicGenre> allGenres(){
		return mgRepo.findAll();
	}
	
	public Page<MusicGenre> allPagedGenres(Pageable p){
		return mgRepo.findAll(p);
	}
	
	public boolean deleteGenre(MusicGenre g) {
		boolean ans = false;
		
		try {
			mgRepo.delete(g);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR DELETING MUSIC GENRE!");
		}
		
		return ans;
	}
}
