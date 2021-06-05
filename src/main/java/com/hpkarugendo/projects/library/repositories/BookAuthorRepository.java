package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.BookAuthor;

@Repository
public interface BookAuthorRepository extends PagingAndSortingRepository<BookAuthor, Integer> {
	List<BookAuthor> findAll();
	Page<BookAuthor> findAll(Pageable pageable);
}
