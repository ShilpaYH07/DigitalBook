package com.books.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.books.model.Books;

public interface IBooksRepository extends JpaRepository<Books, Integer> {
	@Query("SELECT u.bookId fROM Reader u where u.userId=?1")
	List<Integer> findByUserId(Integer uId);


}
