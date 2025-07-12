package com.assignment4.webfluxapp.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Document(collection= "book")
public class Book {
	
	private String title;
	private String author;
	private double price;
	private boolean available;
	private String pubId;
	private String dueDate;
	private String returnDate;
	private String bookId;
	
	
	
	
	
	
	
	public Book() {
		
		// TODO Auto-generated constructor stub
	}



	public Book(String title, String author, double price, boolean available, String pubId, String dueDate,
			String returnDate, String bookId) {
		
		this.title = title;
		this.author = author;
		this.price = price;
		this.available = available;
		this.pubId = pubId;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.bookId = bookId;
	}
	
	
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	public String getPubId() {
		return pubId;
	}
	public void setPubId(String pubId) {
		this.pubId = pubId;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	
	
	

}
