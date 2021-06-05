package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.MusicArtist;

@Repository
public interface MusicArtistRepository extends PagingAndSortingRepository<MusicArtist, Integer> {
	List<MusicArtist> findAll();
	Page<MusicArtist> findAll(Pageable pageable);
}
