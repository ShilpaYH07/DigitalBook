package com.user.service;

import java.awt.print.Book;
import java.util.*;

import com.user.DigitalBooksReaderApplication;
import com.user.model.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Repository.IReaderRepository;
import com.user.model.Reader;
import org.springframework.web.client.RestTemplate;

@Service
public class ReaderServiceImpl implements IReaderService {

	@Autowired
	IReaderRepository repo;

	@Autowired
	private DigitalBooksReaderApplication digitalBooksReaderApplication;

	private final String URI_BOOK_ID = "http://books-microservice/book/{id}";

	@Override
	public Reader saveSubscribeItems(Reader subscribe) {

		Reader savedBook = repo.save(subscribe);
		return savedBook;
	}
	@Override
	public Optional<Reader> getSubscribedBookBysubscriptionId(Integer id) {

		return repo.findById(id);
	}
    
	@Override
	public List<Books> getAllSubscribeItems(){
		List<Reader> reader = repo.findAll();
		reader.stream().forEach(s -> System.out.println(s.toString()));
		List<Books> books = new ArrayList<>();
		Map<String, String> params = new HashMap<String, String>();
		for(int i=0; i<reader.size(); i++) {
			if(reader.get(i).getBookId() != null) {
				params.put("id", "" + reader.get(i).getBookId());
				Books book = digitalBooksReaderApplication.restTemplate().getForObject(URI_BOOK_ID, Books.class, params);
				book.setSubscriptionId(reader.get(i).getSubscriptionId());
				books.add(book);
			}
		}
		System.out.println(books);
		return books;
	}
	
	@Override
	public Reader cancelSubscribeItems(Integer id) {
		repo.deleteById(id);
		System.out.println(id);
		Reader cancelBook = repo.canceBySubscriptionId(id);
		System.out.println(cancelBook);

		return cancelBook;
	}

}
