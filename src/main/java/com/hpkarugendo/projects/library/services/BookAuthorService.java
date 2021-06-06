package com.hpkarugendo.projects.library.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.library.models.BookAuthor;
import com.hpkarugendo.projects.library.repositories.BookAuthorRepository;

@Service
public class BookAuthorService {
	private BookAuthorRepository baRepo;

	public BookAuthorService(BookAuthorRepository baRepo) {
		super();
		this.baRepo = baRepo;
	}
	
	public BookAuthor saveBookAuthor(BookAuthor ba) {
		BookAuthor ans = null;
		
		try {
			ans = baRepo.save(ba);
		} catch (Exception e) {
			System.out.println("ERROR SAVING AUTHOR!!");
		}
		
		return ans;
	}
	
	public List<BookAuthor> allAuthors(){
		return baRepo.findAll();
	}
	
	public Page<BookAuthor> allPagedAuthors(Pageable p){
		return baRepo.findAll(p);
	}
	
	public boolean deleteAthor(BookAuthor ba) {
		boolean ans = false;
		
		try {
			baRepo.delete(ba);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR DELETING AUTHOR!!");
		}
		
		return ans;
	}

}
