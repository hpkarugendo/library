package com.hpkarugendo.projects.library.components;

import java.io.File;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.hpkarugendo.projects.library.models.BookGenre;
import com.hpkarugendo.projects.library.models.Country;
import com.hpkarugendo.projects.library.models.MovieGenre;
import com.hpkarugendo.projects.library.models.MusicGenre;
import com.hpkarugendo.projects.library.repositories.BookGenreRepository;
import com.hpkarugendo.projects.library.repositories.CountryRepository;
import com.hpkarugendo.projects.library.repositories.MovieGenreRepository;
import com.hpkarugendo.projects.library.repositories.MusicGenreRepository;
import com.hpkarugendo.projects.library.services.BookGenreService;
import com.hpkarugendo.projects.library.services.CountryService;
import com.hpkarugendo.projects.library.services.MovieGenreService;
import com.hpkarugendo.projects.library.services.MusicGenreService;

@Component
public class DataComponent implements CommandLineRunner {
	@Autowired
	private CountryRepository cRepo;
	@Autowired
	private MovieGenreRepository mRepo;
	@Autowired
	private MusicGenreRepository muRepo;
	@Autowired
	private BookGenreRepository bRepo;

	@Override
	public void run(String... args) throws Exception {
		CountryService cService = new CountryService(cRepo);
		MovieGenreService mService = new MovieGenreService(mRepo);
		MusicGenreService muService = new MusicGenreService(muRepo);
		BookGenreService bService = new BookGenreService(bRepo);

		if (cService.allCountries().isEmpty()) {
			loadCountries();
		}
		if (mService.allGenres().isEmpty()) {
			loadMovieGenres();
		}
		if (muService.allGenres().isEmpty()) {
			loadMusicGenres();
		}
		if (bService.allGenres().isEmpty()) {
			loadBookGenres();
		}

	}

	private void loadBookGenres() {
		System.out.println("LOADING BOOK GENRE DATA...");
		BookGenreService bgService = new BookGenreService(bRepo);
		File f;
		FileReader fr;
		int counter = 0;

		try {
			f = new ClassPathResource("static/files/book_genre_data.txt").getFile();
			fr = new FileReader(f);
			String line = "";
			for (int start = 0; start != -1; start = fr.read()) {
				if ((char) start != '\n') {
					line = line + (char) start;
				} else {
					line = line.substring(0, line.length() - 1).replace("\u0000", "");
					String name = line.toUpperCase();
					BookGenre bg = new BookGenre(name);
					if (bgService.saveGenre(bg))
						System.out.println("SAVED GENRE - " + bg.getName());
					line = "";
				}
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("ERROR READING BOOK GENRE FILE!!");
		}
		System.out.println("LOADED BOOK GENRE DATA!!!");

	}

	private void loadCountries() {
		System.out.println("LOADING COUNTRY DATA...");
		CountryService cService = new CountryService(cRepo);
		File f;
		FileReader fr;
		int counter = 0;

		try {
			f = new ClassPathResource("static/files/country_data.txt").getFile();
			fr = new FileReader(f);
			String line = "";
			for (int start = 0; start != -1; start = fr.read()) {
				if ((char) start != '\n') {
					line = line + (char) start;
				} else {
					line = line.substring(0, line.length() - 1);
					String n = line.substring(0, line.length() - 3);
					n = n.replace("\"", "");
					n = n.replace("\u0000", "");
					String code = line.substring(line.length() - 2, line.length());
					Country c = new Country(n, code);
					cService.saveCountry(c);
					line = "";
				}
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("ERROR READING COUNTRY FILE!!");
		}
		System.out.println("LOADED COUNTRY DATA!!!");
	}

	private void loadMovieGenres() {

		System.out.println("LOADING MOVIE GENRE DATA...");
		MovieGenreService moService = new MovieGenreService(mRepo);
		File f;
		FileReader fr;
		int counter = 0;

		try {
			f = new ClassPathResource("static/files/movie_genre_data.txt").getFile();
			fr = new FileReader(f);
			String line = "";
			for (int start = 0; start != -1; start = fr.read()) {
				if ((char) start != ',') {
					line = line + (char) start;
				} else {
					String name = line.replace("'", "").strip().toUpperCase();
					name = name.replace("\u0000", "");
					MovieGenre mo = new MovieGenre(name);
					moService.saveGenre(mo);
					System.out.println("SAVED GENRE - " + mo.getName());
					line = "";
				}
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("ERROR READING MOVIE GENRE FILE!!");
		}
		System.out.println("LOADED MOVIE GENRE DATA!!!");

	}

	private void loadMusicGenres() {
		System.out.println("LOADING MUSIC GENRE DATA...");
		MusicGenreService muService = new MusicGenreService(muRepo);
		File f;
		FileReader fr;
		int counter = 0;

		try {
			f = new ClassPathResource("static/files/music_genre_data.txt").getFile();
			fr = new FileReader(f);
			String line = "";
			for (int start = 0; start != -1; start = fr.read()) {
				if ((char) start != ',') {
					line = line + (char) start;
				} else {
					String name = line.strip().toUpperCase();
					name = name.replace("\u0000", "");
					MusicGenre mu = new MusicGenre(name);
					muService.saveGenre(mu);
					System.out.println("SAVED GENRE - " + mu.getName());
					line = "";
				}
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("ERROR READING MUSIC GENRE FILE!!");
		}
		System.out.println("LOADED MUSIC GENRE DATA!!!");
	}

}
