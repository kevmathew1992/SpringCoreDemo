package com.springCoreDemo.dao;

import java.util.ArrayList;
import java.util.List;



import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springCoreDemo.model.Book;

@Repository
public class BookDAOImpl implements BookDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Book> fetchAllBookList() {
		List<Book> bookList = new ArrayList();
		try {

			bookList = sessionFactory.getCurrentSession().createQuery("FROM book WHERE active = 0").list();

		} catch (Exception e) {
			System.out.println("Exception caught in BookDAOImpl fetchAllBookList :: "+e.getMessage());
			e.printStackTrace();
		}

		return bookList;
	}

	public String saveBookDetails(Book book) {
		String message = "";
//		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		try {

			sessionFactory.getCurrentSession().save(book);
			
			message = "Book has been added successfully";
			
//			tx.commit();
			
		} catch (Exception e) {
			message = "Error in adding book";
			System.out.println("Exception caught in BookDAOImpl saveBookDetails :: "+e.getMessage());
			e.printStackTrace();
//			tx.rollback();
		}
		return message;
	}

	public Book fetchBookDetails(int bookId) {
		Book book = new Book();
		try {

			book = (Book) sessionFactory.getCurrentSession().get(Book.class, bookId);
			
		} catch (Exception e) {
			System.out.println("Exception caught in BookDAOImpl fetchBookDetails :: "+e.getMessage());
			e.printStackTrace();
		}
		return book;
	}

	public String updateBookDetails(Book book) {
		String message = "";
		try {
			
			sessionFactory.getCurrentSession().save(book);
			
			message = "Book details have been updated successfully";

		} catch (Exception e) {
			message = "Error in updating book details";
			System.out.println("Exception caught in BookDAOImpl updateBookDetails :: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	public String deleteBookDetails(int bookId) {
		try {

		} catch (Exception e) {
			System.out.println("Exception caught in BookDAOImpl deleteBookDetails :: "+e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

}
