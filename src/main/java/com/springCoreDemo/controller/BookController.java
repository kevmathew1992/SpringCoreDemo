package com.springCoreDemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springCoreDemo.model.Book;
import com.springCoreDemo.service.BookService;

@CrossOrigin("*")
@RestController
public class BookController {
	
	@Autowired
	private BookService bookService;	
	
	@GetMapping("/fetchAllBooks")
	public ResponseEntity<List<Book>> fetchAllBookDetails() {
		List<Book> bookList = new ArrayList();
		try {
			System.out.println("In the controller");

			bookList = bookService.fetchAllBookList();
			
		} catch (Exception e) {
			System.out.println("Exception caught in BookController fetchAllBookDetails");
		}
		return ResponseEntity.ok().body(bookList);
	}
	
	@PostMapping("/addBookDetails")
	public ResponseEntity<String> addBookDetails(@RequestBody Book book) {
		String message = "";
		try {
			System.out.println("Book Name :: "+book.getBookName());
			System.out.println("Author Name :: "+book.getAuthorName());

			message = bookService.saveBookDetails(book);
			
//			JSON
			
		} catch (Exception e) {
			System.out.println("Exception caught in BookController fetchAllBookDetails");
		}
		return ResponseEntity.ok().body(message);
	}

}
