package com.books.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.books.model.Books;
import com.books.service.IBooksService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")

public class BooksController {

	@Autowired
	IBooksService booksService;

	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/savebook")
	public ResponseEntity<Books> saveDigitalBook(@RequestBody Books book) {
		return ResponseEntity.ok().body(booksService.saveDigitalBook(book));
	}

	@GetMapping("/books")
	List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

	@GetMapping("book/{id}")
	public Optional<Books> getBook(@PathVariable("id") Integer bookid) {
		Optional<Books> authorbook = booksService.getBookByBookID(bookid);
		return authorbook;
	}

	@GetMapping("book/author/{authorId}")
	public List<Books> getBookByAuthor(@PathVariable("authorId") Integer authorId) {
		return booksService.getBooksByAuthorId(authorId);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Books> updateBook(@PathVariable("id") Integer id, @RequestBody Books book) {
		return new ResponseEntity<Books>(booksService.updateBook(book, id), HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Books> deleteStudent(@PathVariable Integer id) {
		ResponseEntity<Books> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			booksService.deleteBook(id);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@GetMapping("/search")
	public List<Books> searchBooks(@RequestParam("title") String title, @RequestParam("category") String category,
			@RequestParam("authorName") String authorName, @RequestParam("price") Double price,
			@RequestParam("publisher") String publisher) {

		return booksService.searchBooks(title, category, authorName, price, publisher);

	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/title/{title}")
	public List<Books> searchBookByTitle(@PathVariable String title) {
		System.out.println("inside search by title() "+title);
		return booksService.searchBooksByTitle(title);

	}

	@GetMapping("/category/{category}")
	public List<Books> searchBooksByCategory(@PathVariable String category) {

		return booksService.searchBooksByCategory(category);

	}

	@GetMapping("/author/{author}")
	public List<Books> searchBooksByAuthor(@PathVariable String author) {

		return booksService.searchBooksByAuthor(author);

	}

	@GetMapping("/price/{price}")
	public List<Books> searchBooksByPrice(@PathVariable Double price) {

		return booksService.searchBooksByPrice(price);

	}

	@GetMapping("/publisher/{publisher}")
	public List<Books> searchBooksByPublisher(@PathVariable String publisher) {

		return booksService.searchBooksByPublisher(publisher);

	}

	@GetMapping("/getSubscribe/{id}")
	public List<Books> getData(@PathVariable Integer id) {
		return booksService.subscribedBooks(id);

	}

}