package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.MovieActor;

@Repository
public interface MovieActorRepository extends PagingAndSortingRepository<MovieActor, Integer> {
	List<MovieActor> findAll();
	Page<MovieActor> findAll(Pageable pageable);
}
