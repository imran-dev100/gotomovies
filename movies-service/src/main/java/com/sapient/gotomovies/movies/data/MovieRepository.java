package com.sapient.gotomovies.movies.data;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	List<Movie> findByTitle(String name);
}
