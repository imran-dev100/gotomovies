package com.sapient.gotomovies.booking.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.gotomovies.booking.data.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, UUID>{
}
