package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.Country;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Integer> {
	List<Country> findAll();
	Page<Country> findAll(Pageable pageable);
}
