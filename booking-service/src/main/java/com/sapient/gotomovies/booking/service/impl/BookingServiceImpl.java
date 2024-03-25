package com.sapient.gotomovies.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.gotomovies.booking.data.Booking;
import com.sapient.gotomovies.booking.data.Seat;
import com.sapient.gotomovies.booking.dto.BookingDto;
import com.sapient.gotomovies.booking.dto.PaymentDto;
import com.sapient.gotomovies.booking.enums.SeatStatus;
import com.sapient.gotomovies.booking.repository.BookingRepository;
import com.sapient.gotomovies.booking.repository.SeatRepository;
import com.sapient.gotomovies.booking.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private SeatRepository seatRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${api.payment}")
	private String paymentApi;

	@Override
	public BookingDto book(final BookingDto bookingDto) {
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		final HttpEntity<PaymentDto> request = new HttpEntity<>(bookingDto.getPaymentDto(), headers);
		final PaymentDto paymentDto = restTemplate.postForObject(paymentApi, request, PaymentDto.class);

		// Seat insert
		final List<Seat> seats = new ArrayList<>();

		bookingDto.getSeatNumbers().stream()
				.forEach(s -> seats.add(Seat.builder().seatNumber(s).showId(bookingDto.getShowId())
						.theatreId(bookingDto.getTheaterId()).status(SeatStatus.BOOKED).build()));

		seatRepository.saveAll(seats);

		
		// Create booking
		final Booking booking = bookingRepository.save(
				Booking.builder().seats(seats).transactionId(bookingDto.getPaymentDto().getTransactionId()).build());

		bookingDto.setPaymentDto(paymentDto);
		bookingDto.setId(booking.getId());
		bookingDto.setCreatedAt(booking.getCreatedAt());
		bookingDto.setCreatedBy(booking.getCreatedBy());
		bookingDto.setUpdatedAt(booking.getUpdatedAt());
		bookingDto.setUpdatedBy(booking.getUpdatedBy());

		return bookingDto;
	}
}
