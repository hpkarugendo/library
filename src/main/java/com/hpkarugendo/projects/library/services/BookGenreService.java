package com.hpkarugendo.projects.library.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.library.models.BookGenre;
import com.hpkarugendo.projects.library.repositories.BookGenreRepository;

@Service
public class BookGenreService {
	private BookGenreRepository bgRepo;

	public BookGenreService(BookGenreRepository bgRepo) {
		super();
		this.bgRepo = bgRepo;
	}
	
	public boolean saveGenre(BookGenre g) {
		boolean ans = false;
		
		try {
			bgRepo.save(g);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR SAVING GENRE!!");
		}
		
		return ans;
	}
	
	public List<BookGenre> allGenres(){
		return bgRepo.findAll();
	}
	
	public Page<BookGenre> allPagedGenres(Pageable p){
		return bgRepo.findAll(p);
	}
	
	public boolean deleteGenre(BookGenre g) {
		boolean ans = false;
		
		try {
			bgRepo.delete(g);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR DELETING GENRE!!");
		}
		
		return ans;
	}

}
