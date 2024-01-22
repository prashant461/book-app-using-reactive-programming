package com.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reactive.entity.Book;
import com.reactive.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Mono<Book> create(Book book) {
		Mono<Book> createdBook =  bookRepository.save(book);
		return createdBook;
	}

	@Override
	public Flux<Book> getAll() {
		Flux<Book> allBooks = bookRepository.findAll();
		return allBooks;
	}

	@Override
	public Mono<Book> get(int bookId) {
		Mono<Book> book = bookRepository.findById(bookId);
		return book;
	}

	@Override
	public Mono<Book> update(Book book, int bookId) {
		Mono<Book> oldBook = bookRepository.findById(bookId);
		
		Mono<Book> updatedBook = oldBook.flatMap(book1->{
			book1.setName(book.getName());
			book1.setAuthor(book.getAuthor());
			book1.setDescription(book.getDescription());
			book1.setPublisher(book.getPublisher());
			
			return bookRepository.save(book1);
		});
		
		return updatedBook;
	}

	@Override
	public Mono<Void> delete(int bookId) {
		Mono<Void> deletedBook = bookRepository.findById(bookId)
									.flatMap(book->bookRepository
												.deleteById(bookId));
		
		return deletedBook;
	}

	@Override
	public Flux<Book> search(String query) {
		Flux<Book> foundBook = bookRepository.searchBookByTitle(query);
		return foundBook;
	}

}
