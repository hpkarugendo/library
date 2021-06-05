package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.BookGenre;

@Repository
public interface BookGenreRepository extends PagingAndSortingRepository<BookGenre, Integer> {
	List<BookGenre> findAll();
	Page<BookGenre> findAll(Pageable pageable);
}
