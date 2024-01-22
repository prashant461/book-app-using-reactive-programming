package com.reactive.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("book_details")
public class Book {
	
	@Id
	private int bookId;
	
	private String name;
	
	private String description;
	
	private String publisher;
	
	private String author;
	
	public Book() {
		super();
	}

	public Book(int bookId, String name, String description, String publisher, String author) {
		super();
		this.bookId = bookId;
		this.name = name;
		this.description = description;
		this.publisher = publisher;
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}
