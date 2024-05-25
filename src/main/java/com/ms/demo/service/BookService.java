package com.ms.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.ms.demo.entities.Book;

@Service
public class BookService {

	private static List<Book> booklist = new ArrayList<Book>();
	
	static {
		booklist.add(new Book(1, "Java", "N Ramaya"));
		booklist.add(new Book(2, "Python", "V Panda Raman"));
		booklist.add(new Book(3, "C++", "James Chadwicks"));
	}
	
	
	
	
	//Fetching All books
	public List<Book> getAllBooks() {
		return booklist;
	}
	
	//Fetching Single book by id
	public Book getBook(int id) {
		Book book = booklist.stream().filter(e->e.getId()==id).findFirst().get();
		return book;
	}
	
	//Save book
		public Book saveBook(Book book) {
			booklist.add(book);
			return book;
		}
	
	//delete book
		public String deleteBookById(int id) {
		
			booklist = booklist.stream().filter(book-> book.getId()!=id).collect(Collectors.toList());
	
			return "Book deleted successfully(id="+id+")";
		}
	
		//update book
		public void updateBook(Book book, int id) {
			/*booklist.stream().map(b -> {
				if(b.getId()==id) {
					b.setName(book.getName());
					b.setAuthor(book.getAuthor());
				}
			}).collect(Collectors.toList());*/
			
			booklist.forEach(bokk-> {
				if(bokk.getId()==id) {
					bokk.setId(book.getId());
					bokk.setName(book.getName());
					bokk.setAuthor(book.getAuthor());
				}
			});
			
		}
}
