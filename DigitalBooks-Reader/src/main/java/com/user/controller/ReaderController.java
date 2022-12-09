package com.user.controller;

import java.util.List;

import com.user.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.user.model.Reader;
import com.user.service.IReaderService;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class ReaderController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IReaderService readerService;

	@GetMapping("/getData/{id}")
	public Object getData(@PathVariable("id") Integer bookId) {
		Object records = restTemplate.getForObject("http://books-microservice/book/" + bookId, Object.class);

		return records;
	}

	@GetMapping("/getBooks")
	public Object getAllBooks() {
		Object records = restTemplate.getForObject("http://books-microservice/books/", Object.class);

		return records;
	}

	@GetMapping("/searchBook")
	public Object searchBooks(@RequestParam("category") String category, @RequestParam("authorName") String authorName,
			@RequestParam("price") Double price, @RequestParam("title") String title,@RequestParam("publisher") String publisher) {

		String url = "http://books-microservice/search&category={category}&authorName={authorName}&price={price}&title={title}&publisher={publisher}";

		Object records = restTemplate.getForObject(url, Object.class);

		return records;

	}

	@GetMapping("/searchCategory/{cat}")
	public Object searchBooksBycategory(@PathVariable String cat) {

		String url = "http://books-microservice/category/";

		Object records = restTemplate.getForObject(url + cat, Object.class);

		return records;

	}

	@GetMapping("/searchAuthor/{author}")
	public Object searchBooksByAuthor(@PathVariable String author) {

		String url = "http://books-microservice/author/";

		Object records = restTemplate.getForObject(url + author, Object.class);

		return records;

	}

	@GetMapping("/searchPrice/{price}")
	public Object searchBooksByPrice(@PathVariable Double price) {

		String url = "http://books-microservice/price/";

		Object records = restTemplate.getForObject(url + price, Object.class);

		return records;

	}
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/searchTitle/{title}")
	public Object searchBooksByTitle(@PathVariable String title) {
		System.out.println("inside search book by title");
		String url = "http://books-microservice/title/";

		Object records = restTemplate.getForObject(url + title, Object.class);

		return records;

	}
	
	@GetMapping("/searchPublisher/{publisher}")
	public Object searchBooksByPublisher(@PathVariable String publisher) {
		
		String url = "http://books-microservice/publisher/";
		System.out.println("inside Reader - searchbookbypublisher() "+publisher);
		Object records = restTemplate.getForObject(url+ publisher, Object.class );
		System.out.println(records);
				return records;
		
	}

	@PostMapping("/subscribe")
	public Reader saveSubscribeBook(@RequestBody Reader read) {
		return readerService.saveSubscribeItems(read);

	}
	
	@GetMapping("/books")
	List<Books> getAllSubscribeBooks() {
		return readerService.getAllSubscribeItems();
	}
	
	@GetMapping("/cancelSubscribe/{id}")
	public Reader cancelSubscribeBook(@PathVariable Integer id ) {
		return readerService.cancelSubscribeItems(id);
	}
}
