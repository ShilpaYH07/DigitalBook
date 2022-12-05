package com.books.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.books.Repository.IBooksRepository;
import com.books.exception.ResourceNotFoundException;
import com.books.model.Books;

@Service
public class BooksServiceImpl implements IBooksService {

	@Autowired
	IBooksRepository booksrepository;

	@Transactional
	public Books saveDigitalBook(Books book) {
		return booksrepository.save(book);

	}

	@Override
	public List<Books> getAllBooks() {
		return booksrepository.findAll();
	}

	@Override
	public Optional<Books> getBookByBookID(Integer id) {

		return booksrepository.findById(id);
	}

	@Override
	public List<Books> getBooksByAuthorId(Integer authorId) {
		List<Books> books = booksrepository.findAll();
		return books.stream().filter(book -> book.getAuthorId().equals(authorId)).collect(Collectors.toList());

	}

	@Override
	public List<Books> searchBooks(String title, String category, String author, Double price, String publisher) {
		List<Books> books = booksrepository.findAll();
		return books.stream()
				.filter(book -> book.getTitle().equalsIgnoreCase(title) || book.getCategory().equalsIgnoreCase(category)
						|| book.getAuthor().equalsIgnoreCase(author) || book.getPrice().equals(price)
						|| book.getPublisher().equalsIgnoreCase(publisher))
				.collect(Collectors.toList());

	}

	@Override
	public Books updateBook(Books book, Integer id) {
		Books existingbook = booksrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Book", "id", id));
		existingbook.setTitle(book.getTitle());
		existingbook.setActive(book.getActive());
		existingbook.setPrice(book.getPrice());
		existingbook.setPublisher(book.getPublisher());
		existingbook.setContent(book.getContent());
		booksrepository.save(existingbook);
		return existingbook;
	}

	@Override
	public void deleteBook(Integer id) {
		booksrepository.deleteById(id);

	}

	@Override
	public List<Books> searchBooksByCategory(String category) {
		List<Books> books = booksrepository.findAll();
		System.out.println("inside search by category");
		return books.stream().filter(book -> book.getCategory().contains(category))
				.collect(Collectors.toList());

	}

	@Override
	public List<Books> searchBooksByAuthor(String author) {
		System.out.println("inside search by author");
		List<Books> books = booksrepository.findAll();
		return books.stream().filter(book -> book.getAuthor().contains(author)).collect(Collectors.toList());
	}

	@Override
	public List<Books> searchBooksByTitle(String title) {
		System.out.println("inside search by title");
		List<Books> books = booksrepository.findAll();
		return books.stream().filter(book -> book.getTitle().contains(title)).collect(Collectors.toList());
	}

	@Override
	public List<Books> searchBooksByPublisher(String publisher) {
		System.out.println("inside search by publisher");
		List<Books> books = booksrepository.findAll();
		return books.stream().filter(book -> book.getPublisher().contains(publisher))
				.collect(Collectors.toList());
	}

	@Override
	public List<Books> searchBooksByPrice(Double price) {

		List<Books> books = booksrepository.findAll();
		return books.stream().filter(book -> book.getPrice().equals(price)).collect(Collectors.toList());
	}

	@Override
	public List<Books> subscribedBooks(Integer Id) {

		List<Integer> bookid = booksrepository.findByUserId(Id);
		List<Books> books = new ArrayList<Books>();
		for (int i = 0; i < bookid.size(); i++) {

			Optional<Books> book = booksrepository.findById(bookid.get(i));
			if (book.isPresent()) {
				books.add(book.get());
			}
		}
		return books;

	}

}
