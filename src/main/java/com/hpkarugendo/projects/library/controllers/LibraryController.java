package com.hpkarugendo.projects.library.controllers;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hpkarugendo.projects.library.models.Book;
import com.hpkarugendo.projects.library.models.BookAuthor;
import com.hpkarugendo.projects.library.models.Country;
import com.hpkarugendo.projects.library.services.BookAuthorService;
import com.hpkarugendo.projects.library.services.BookGenreService;
import com.hpkarugendo.projects.library.services.BookService;
import com.hpkarugendo.projects.library.services.CountryService;
import com.hpkarugendo.projects.library.services.ImageService;
import com.hpkarugendo.projects.library.services.MovieGenreService;
import com.hpkarugendo.projects.library.services.MusicGenreService;

@Controller
public class LibraryController {
	@Autowired
	private BookService bService;
	@Autowired
	private BookAuthorService baService;
	@Autowired
	private CountryService cService;
	@Autowired
	private BookGenreService bgService;
	@Autowired
	private MovieGenreService mgService;
	@Autowired
	private MusicGenreService muService;

	@GetMapping({ "/", "projects/library" })
	public String library() {
		return "projects/library/index";
	}
	
	/*
	 * The Following Section Deals With Books
	 */
	//List All Books in chunks of 5
	@GetMapping("projects/library/books/{no}")
	public String bookLibrary(Model m, @PathVariable("no") final int no) {
		m.addAttribute("books", bService.allPagedBooks(PageRequest.of(no, 4, Sort.by("title"))));
		return "projects/library/book_library";
	}
	//Form to Add New Book
	@GetMapping("projects/library/books/new")
	public String bookForm(Model m) {
		if (!m.containsAttribute("bookObject")) {
			m.addAttribute("bookObject", new Book());
		}
		m.addAttribute("authors", baService.allAuthors());
		m.addAttribute("countries", cService.allCountries());
		m.addAttribute("genres", bgService.allGenres());
		return "projects/library/book_form";
	}
	//Save New Book
	@PostMapping("projects/library/books/new")
	public String bookPost(@ModelAttribute("bookObject") Book book, @RequestParam("file") MultipartFile file, RedirectAttributes ra, HttpServletRequest sr) {
		if(!file.isEmpty()) {
			ImageService iService = new ImageService(file, "books");
			book.setImage(iService.getUrl());
		}
		
		if(!sr.getParameter("nName").toString().isEmpty()) {
			String name = sr.getParameter("nName").toString();
			char sex = sr.getParameter("nGender").toString().charAt(0);
			int id = Integer.parseInt(sr.getParameter("nCountry").toString());
			Country country = cService.findById(id);
			BookAuthor ba = new BookAuthor(name, sex, country);
			if(book.getAuthor() == null || book.getAuthor().getId() < 1 ) {
				book.setAuthor(ba);
			}
		}
		if(bService.saveBook(book)) {
			ra.addFlashAttribute("mOk", "Book Saved Successfully");
			return "redirect:/projects/library/books/0";
		} else {
			ra.addFlashAttribute("mNo", "Book Couldn't Be Saved!!");
			ra.addFlashAttribute("bookObject", book);
			return "redirect:/projects/library/books/new";
		}
	}

}
