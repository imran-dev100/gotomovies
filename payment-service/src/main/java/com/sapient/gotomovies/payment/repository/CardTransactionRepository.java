package com.sapient.gotomovies.payment.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.gotomovies.payment.data.CardTransaction;

@Repository
public interface CardTransactionRepository extends CrudRepository<CardTransaction, UUID>{

}
