package com.sapient.gotomovies.booking.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class BookingDto extends BaseAuditDto {
	
	private UUID id;

	@JsonProperty("theatre_id")
	private UUID theaterId;

	@JsonProperty("show_id")
	private UUID showId;

	@JsonProperty("seat_numbers")
	private List<Integer> seatNumbers;
	
	@JsonProperty("payment")
	private PaymentDto paymentDto;
	
	private String description;
}
