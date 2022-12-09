package com.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.model.Reader;
@Repository
public interface IReaderRepository extends JpaRepository<Reader, Integer> {
	@Query(value="select * from Reader where digitalBook_id=?1",nativeQuery = true)
	Reader canceBySubscriptionId(Integer id);

}
