package com.sapient.gotomovies.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.gotomovies.booking.dto.BookingDto;
import com.sapient.gotomovies.booking.service.BookingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/booking")
@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Bad Request"),
		@ApiResponse(responseCode = "401", description = "Unauthorized Access"),
		@ApiResponse(responseCode = "404", description = "Resource Not Found"),
		@ApiResponse(responseCode = "500", description = "Internal Server error"),
		@ApiResponse(responseCode = "200", description = "Success") })
@Tag(name = "Booking", description = "BookingController")
@RestController
public class BookingController {

	@Autowired
	private BookingService bookingService;
	
	@Operation(summary = "Booking API")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "API to book list of seats and request payment") })
	@PostMapping("/book")
	public ResponseEntity<BookingDto> book(@RequestBody BookingDto bookingDto) {
		return new ResponseEntity<>(bookingService.book(bookingDto), HttpStatus.OK);
	}
}
