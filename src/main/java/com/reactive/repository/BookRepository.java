package com.reactive.repository;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.reactive.entity.Book;

import reactor.core.publisher.Flux;

@Repository
public interface BookRepository extends ReactiveCrudRepository<Book, Integer>{

	@Query("SELECT * FROM book_details WHERE name LIKE CONCAT('%', :title, '%')")
	Flux<Book> searchBookByTitle(@Param("title") String title);


}
