package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.MovieDirector;

@Repository
public interface MovieDirectorRepository extends PagingAndSortingRepository<MovieDirector, Integer> {
	List<MovieDirector> findAll();
	Page<MovieDirector> findAll(Pageable pageable);
}
