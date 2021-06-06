package com.hpkarugendo.projects.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.library.models.Book;
import com.hpkarugendo.projects.library.models.BookAuthor;
import com.hpkarugendo.projects.library.repositories.BookRepository;

@Service
public class BookService {
	private BookRepository bRepo;
	@Autowired
	private BookAuthorService baService;

	public BookService(BookRepository bRepo) {
		super();
		this.bRepo = bRepo;
	}
	
	public boolean saveBook(Book b) {
		boolean ans = false;
		try {
			if(b.getAuthor().getId() < 1) {
				BookAuthor ba = baService.saveBookAuthor(b.getAuthor());
				if(ba != null) {
					b.setAuthor(ba);
				}
			}
			bRepo.save(b);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR SAVING BOOK!!");
		}
		
		return ans;
	}
	
	public List<Book> allBooks(){
		return bRepo.findAll();
	}
	
	public Page<Book> allPagedBooks(Pageable p){
		return bRepo.findAll(p);
	}
	
	public boolean deleteBook(Book b) {
		boolean ans = false;
		
		try {
			bRepo.delete(b);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR DELETING BOOK!!");
		}
		
		return ans;
	}

}
