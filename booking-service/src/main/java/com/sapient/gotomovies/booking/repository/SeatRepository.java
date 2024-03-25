package com.sapient.gotomovies.booking.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.gotomovies.booking.data.Seat;

@Repository
public interface SeatRepository extends CrudRepository<Seat, UUID> {
}
