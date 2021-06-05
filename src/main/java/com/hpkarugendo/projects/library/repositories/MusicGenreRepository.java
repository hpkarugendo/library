package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.MusicGenre;

@Repository
public interface MusicGenreRepository extends PagingAndSortingRepository<MusicGenre, Integer> {
	List<MusicGenre> findAll();
	Page<MusicGenre> findAll(Pageable pageable);
}
