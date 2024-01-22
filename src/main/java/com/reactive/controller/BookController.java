package com.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reactive.entity.Book;
import com.reactive.service.BookService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;

//	Create new books
	
	@PostMapping
	public Mono<Book> create(@RequestBody Book book) {
		return bookService.create(book);
	}
	
//	get all books
	
	@GetMapping
	public Flux<Book> getAll() {
		return bookService.getAll();
	}
	
//	get single book by book id
	
	@GetMapping("/{bId}")
	public Mono<Book> get(@PathVariable("bId") int bookId) {
		return bookService.get(bookId);
	}
	
//	update book 

	@PutMapping("/{bId}")
	public Mono<Book> updateBook(@PathVariable("bId") int bookId, @RequestBody Book book) {
		return bookService.update(book, bookId);
	}
	
//	delete book by id
	
	@DeleteMapping("{bId}")
	public Mono<Void> delete(@PathVariable("bId") int bookId) {
		return bookService.delete(bookId);
	}
	
//	search book by query
	
	@GetMapping("/search}")
	public Flux<Book> search(@RequestParam String query) {
		return bookService.search(query);
	}
	
	
}
