package com.hpkarugendo.projects.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.hpkarugendo.projects.library.models.Country;
import com.hpkarugendo.projects.library.repositories.CountryRepository;

@Service
public class CountryService {
	private CountryRepository cRepo;
	
	public CountryService(CountryRepository repo) {
		this.cRepo = repo;
	}

	public boolean saveCountry(Country c) {
		boolean ans = false;
		
		try {
			cRepo.save(c);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR SAVING COUNTRY - " + c.getName());
		}
		
		return ans;
	}
	
	public List<Country> allCountries(){
		return cRepo.findAll();
	}
	
	public Page<Country> allPagedCountries(Pageable p){
		return cRepo.findAll(p);
	}
	
	public Country findById(int id) {
		return cRepo.findById(id).get();
	}
	
	public boolean deleteCountry(Country c) {
		boolean ans = false;
		
		try {
			cRepo.delete(c);
			ans = true;
		} catch (Exception e) {
			System.out.println("ERROR DELETING COUNTRY!");
		}
		
		return ans;
	}
}
