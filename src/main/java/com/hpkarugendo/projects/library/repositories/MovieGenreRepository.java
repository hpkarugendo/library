package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.MovieGenre;

@Repository
public interface MovieGenreRepository extends PagingAndSortingRepository<MovieGenre, Integer> {
	List<MovieGenre> findAll();
	Page<MovieGenre> findAll(Pageable pageable);
}
