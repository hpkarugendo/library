package com.hpkarugendo.projects.library.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hpkarugendo.projects.library.models.Book;

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Integer> {
	List<Book> findAll();
	Page<Book> findAll(Pageable pageable);
}
