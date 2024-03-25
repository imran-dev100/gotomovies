package com.sapient.gotomovies.booking.data;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sapient.gotomovies.booking.data.helper.BaseEntity;
import com.sapient.gotomovies.booking.enums.SeatStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "seats")
public class Seat extends BaseEntity  {

	@Id
	@UuidGenerator
	private UUID id;

	@Column(name="theatre_id")
	private UUID theatreId;

	@Column(name="show_id")
	private UUID showId;

	@Column(name="seat_number")
	private int seatNumber;

	@Enumerated(EnumType.STRING)
	private SeatStatus status;
}