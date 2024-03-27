package com.sapient.gotomovies.movies.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.gotomovies.movies.data.MovieRepository;
import com.sapient.gotomovies.movies.dto.MovieDto;
import com.sapient.gotomovies.movies.mapper.MovieMapper;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private MovieMapper movieMapper;

	@Override
	public MovieDto add(final MovieDto movieDto) {
		return movieMapper.convertToDto(movieRepository.save(movieMapper.convertToDocument(movieDto)));
	}

	@Override
	public List<MovieDto> getMovieByName(final String name) {
		return movieMapper.convertToDto(movieRepository.findByTitle(name));
	}
}
