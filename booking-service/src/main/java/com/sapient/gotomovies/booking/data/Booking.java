package com.sapient.gotomovies.booking.data;

import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sapient.gotomovies.booking.data.helper.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name = "bookings")
public class Booking extends BaseEntity {

	@Id
	@UuidGenerator
	private UUID id;
	@OneToMany(mappedBy = "id", cascade = CascadeType.ALL)
	private List<Seat> seats;
	private String transactionId;
}
