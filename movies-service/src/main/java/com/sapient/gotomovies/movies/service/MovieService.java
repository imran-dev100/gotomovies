package com.sapient.gotomovies.movies.service;

import java.util.List;

import com.sapient.gotomovies.movies.dto.MovieDto;

public interface MovieService {
	MovieDto add(MovieDto movieDto);

	List<MovieDto> getMovieByName(String name);
}
