package com.ms.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.demo.entities.Book;
import com.ms.demo.service.BookService;

@RestController
public class BookContrller {
	
	@Autowired
	BookService service;	
	
	@GetMapping("/books")
	public List<Book> getAllBooks() {
		return service.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBookById(@PathVariable("id") int id) {
		return service.getBook(id);
	}
	
	@PostMapping("/save")
	public Book saveBook(@RequestBody Book book) {
		return service.saveBook(book);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteBookId(@PathVariable("id") int id) {
		return service.deleteBookById(id);
	}
	
	@PutMapping("update/{bid}")//@RequestBody used to take the json object and bind with given object
	public Book putMethodName(@RequestBody Book book, @PathVariable("bid") int id) {
		//TODO: process PUT request
		
		 service.updateBook(book, id);
		 return book;
	}
	
}
