package com.springCoreDemo.dao;

import java.util.List;

import com.springCoreDemo.model.Book;


public interface BookDAO {

	List<Book> fetchAllBookList();	
	String saveBookDetails(Book book);
	Book fetchBookDetails(int bookId);
	String updateBookDetails(Book book);
	String deleteBookDetails(int bookId);
}
