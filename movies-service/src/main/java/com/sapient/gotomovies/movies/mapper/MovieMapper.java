package com.sapient.gotomovies.movies.mapper;

import java.util.List;
import org.springframework.stereotype.Component;

import com.sapient.gotomovies.movies.data.Movie;
import com.sapient.gotomovies.movies.dto.MovieDto;

@Component
public class MovieMapper {
	
	public Movie convertToDocument(final MovieDto dto) {
		return Movie.builder()
				 .id(dto.getId())
				 .title(dto.getTitle())
				 .description(dto.getDescription())
				 .language(dto.getLanguage())
				 .releaseDate(dto.getReleaseDate())
				 .genre(dto.getGenre())
				 .reviews(dto.getReviews())
				 .build();
	}

	public MovieDto convertToDto(final Movie document) {
		final MovieDto dto = MovieDto.builder()
			 .id(document.getId())
			 .title(document.getTitle())
			 .description(document.getDescription())
			 .language(document.getLanguage())
			 .releaseDate(document.getReleaseDate())
			 .genre(document.getGenre())
			 .reviews(document.getReviews())
			 .build();
		dto.setCreatedBy(document.getCreatedBy());
		dto.setUpdatedBy(document.getUpdatedBy());
		dto.setCreatedAt(document.getCreatedAt());
		dto.setUpdatedAt(document.getUpdatedAt());
	 
		return dto;
	}

	public List<MovieDto> convertToDto(final List<Movie> documents) {
		return documents.stream().map(this::convertToDto).toList();
	}
}
