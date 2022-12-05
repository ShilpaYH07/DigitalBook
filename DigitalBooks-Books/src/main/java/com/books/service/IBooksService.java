package com.books.service;

import java.util.List;
import java.util.Optional;

import com.books.model.Books;

public interface IBooksService {

	public List<Books> getAllBooks();

	Optional<Books> getBookByBookID(Integer id);

	public List<Books> getBooksByAuthorId(Integer authorId);

	Books updateBook(Books book, Integer id);

	public void deleteBook(Integer id);

	public List<Books> searchBooks(String title, String category, String authorName, Double price, String publisher);

	public List<Books> searchBooksByTitle(String title);

	public List<Books> searchBooksByCategory(String category);

	public List<Books> searchBooksByAuthor(String author);

	public List<Books> searchBooksByPrice(Double price);

	public List<Books> searchBooksByPublisher(String publisher);

	public List<Books> subscribedBooks(Integer Id);

	public Books saveDigitalBook(Books book);

}
