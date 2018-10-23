package com.springCoreDemo.service;

import java.util.List;

import com.springCoreDemo.model.Book;

public interface BookService {

	List<Book> fetchAllBookList();	
	String saveBookDetails(Book book);
	Book fetchBookDetails(int bookId);
	String updateBookDetails(Book book);
	String deleteBookDetails(int bookId);
}
