package com.sapient.gotomovies.movies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoAuditing
@EnableMongoRepositories
@SpringBootApplication
public class MoviesServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesServiceApplication.class, args);
	}
}
