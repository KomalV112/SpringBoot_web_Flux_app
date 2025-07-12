package com.assignment4.webfluxapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment4.webfluxapp.pojo.Book;
import com.assignment4.webfluxapp.repository.BookRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BookService {
	@Autowired
	
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository= bookRepository;
	}
	
	public Flux<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Mono<Book> addBook(Book book){
		return bookRepository.save(book);
	}

	public Mono<Void> deleteBook(String id){
		return bookRepository.deleteById(id);
	}
}
