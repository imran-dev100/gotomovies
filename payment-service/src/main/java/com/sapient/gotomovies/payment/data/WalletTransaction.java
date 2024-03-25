package com.sapient.gotomovies.payment.data;

import java.util.UUID;

import com.sapient.gotomovies.payment.data.helper.Transaction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name="wallet_transaction")
public class WalletTransaction extends Transaction{

	private UUID userId;
	private double amount;
	
	@Column(name="wallet_id")
	private long walletId;
	
	@Column(name="service_provider")
	private String serviceProvider;
	
	private String description;
}
