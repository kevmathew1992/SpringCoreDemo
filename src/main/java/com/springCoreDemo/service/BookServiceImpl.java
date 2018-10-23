package com.springCoreDemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springCoreDemo.dao.BookDAO;
import com.springCoreDemo.model.Book;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDAO bookDAO;
		
	public List<Book> fetchAllBookList() {
		List<Book> bookList = new ArrayList();
		try {

			bookList = bookDAO.fetchAllBookList();
		} catch (Exception e) {
			System.out.println("Exception caught in BookServiceImpl fetchAllBookList");
		}
		return bookList;
	}

	public String saveBookDetails(Book book) {
		String message = "";
		try {

			message = bookDAO.saveBookDetails(book);
		} catch (Exception e) {
			System.out.println("Exception caught in BookServiceImpl saveBookDetails");
		}
		return message;
	}

	public Book fetchBookDetails(int bookId) {
		try {

		} catch (Exception e) {
			System.out.println("Exception caught in BookServiceImpl fetchBookDetails");
		}
		return null;
	}

	public String updateBookDetails(Book book) {
		try {

		} catch (Exception e) {
			System.out.println("Exception caught in BookServiceImpl updateBookDetails");
		}
		return null;
	}

	public String deleteBookDetails(int bookId) {
		try {

		} catch (Exception e) {
			System.out.println("Exception caught in BookServiceImpl deleteBookDetails");
		}
		return null;
	}

}
