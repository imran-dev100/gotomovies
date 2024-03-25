package com.sapient.gotomovies.payment.data;

import java.util.UUID;

import com.sapient.gotomovies.payment.data.helper.Transaction;
import com.sapient.gotomovies.payment.enums.CardType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name="card_transaction")
public class CardTransaction extends Transaction{

	private UUID userId;
	private double amount;
	@Column(name="card_number")
	private long cardNumber;
	@Enumerated(EnumType.STRING)
	private CardType type;
	private String bank;
	private String description;
}
