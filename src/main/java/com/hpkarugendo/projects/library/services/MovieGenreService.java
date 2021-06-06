package com.hpkarugendo.projects.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.library.models.MovieGenre;
import com.hpkarugendo.projects.library.repositories.MovieGenreRepository;

@Service
public class MovieGenreService {
	private MovieGenreRepository mgRepo;
	
	public MovieGenreService(MovieGenreRepository mgRepo) {
		super();
		this.mgRepo = mgRepo;
	}

	public boolean saveGenre(MovieGenre g) {
		boolean ans = false;
		
		try {
			mgRepo.save(g);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR SAVING MOVIE GENRE!");
		}
		
		return ans;
	}
	
	public List<MovieGenre> allGenres(){
		return mgRepo.findAll();
	}
	
	public Page<MovieGenre> allPagedGenres(Pageable p){
		return mgRepo.findAll(p);
	}
	
	public boolean deleteGenre(MovieGenre g) {
		boolean ans = false;
		
		try {
			mgRepo.delete(g);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR DELETING MOVIE GENRE!");
		}
		
		return ans;
	}

}
