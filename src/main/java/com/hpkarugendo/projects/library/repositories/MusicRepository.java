package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.Music;

@Repository
public interface MusicRepository extends PagingAndSortingRepository<Music, Integer> {
	List<Music> findAll();
	Page<Music> findAll(Pageable pageable);
}
