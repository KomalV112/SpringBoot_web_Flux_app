 package com.assignment4.webfluxapp.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment4.webfluxapp.pojo.Book;
import com.assignment4.webfluxapp.service.BookService;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("books")
public class BookController {
	
	private final BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping 
	public Flux<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@PostMapping
	public Mono<Book> addBook(@RequestBody Book book){
		return bookService.addBook(book);
	}
	
	@DeleteMapping("/{id}")
	public Mono<Void> delteBook(@PathVariable String id){
		return bookService.deleteBook(id);
	}

}
