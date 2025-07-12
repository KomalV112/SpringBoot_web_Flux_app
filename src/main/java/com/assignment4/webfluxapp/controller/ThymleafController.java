package com.assignment4.webfluxapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.assignment4.webfluxapp.pojo.Book;
import com.assignment4.webfluxapp.service.BookService;

@Controller
public class ThymleafController {
	
	private final BookService bookService;
	
	public ThymleafController (BookService bookService) {
		this.bookService=bookService;
	}
	
	
	@GetMapping("/addBook")
	public String addBookForm() {
		return "addBook";
	}
	
	@PostMapping("/addBook")
	public String addBook(Book book) {
		bookService.addBook(book).subscribe();
		return "redirect:/addBook";
	}

}
