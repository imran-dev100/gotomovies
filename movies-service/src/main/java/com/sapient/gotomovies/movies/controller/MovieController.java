package com.sapient.gotomovies.movies.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.gotomovies.movies.dto.MovieDto;
import com.sapient.gotomovies.movies.service.MovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/movie")
@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Bad Request"),
		@ApiResponse(responseCode = "401", description = "Unauthorized Access"),
		@ApiResponse(responseCode = "404", description = "Resource Not Found"),
		@ApiResponse(responseCode = "500", description = "Internal Server error"),
		@ApiResponse(responseCode = "200", description = "Success") })
@Tag(name = "Movie", description = "MovieController")
@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;

	@Operation(summary = "Create Movie API")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "API to book list of seats and request payment") })
	@PostMapping
	public ResponseEntity<MovieDto> add(@RequestBody MovieDto movieDto) {
		return new ResponseEntity<>(movieService.add(movieDto), HttpStatus.OK);
	}

	@Operation(summary = "Get Movie by name API")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "API to find movie by name") })
	@GetMapping
	public ResponseEntity<List<MovieDto>> getMovieByName(@RequestParam(required = true) String name) {
		return new ResponseEntity<>(movieService.getMovieByName(name), HttpStatus.OK);
	}
}
