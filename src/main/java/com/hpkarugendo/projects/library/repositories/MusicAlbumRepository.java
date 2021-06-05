package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.MusicAlbum;

@Repository
public interface MusicAlbumRepository extends PagingAndSortingRepository<MusicAlbum, Integer> {
	List<MusicAlbum> findAll();
	Page<MusicAlbum> findAll(Pageable pageable);
}
