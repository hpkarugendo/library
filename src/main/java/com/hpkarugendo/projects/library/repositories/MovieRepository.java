package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.Movie;

@Repository
public interface MovieRepository extends PagingAndSortingRepository<Movie, Integer>{
	List<Movie> findAll();
	Page<Movie> findAll(Pageable pageable);
}
