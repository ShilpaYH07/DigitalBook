package com.user.service;

import java.util.List;
import java.util.Optional;

import com.user.model.Books;
import com.user.model.Reader;

public interface IReaderService {

	public Reader saveSubscribeItems(Reader read);

	Optional<Reader> getSubscribedBookBysubscriptionId(Integer id);

	public List<Books> getAllSubscribeItems();

	Reader cancelSubscribeItems(Integer id);

}
