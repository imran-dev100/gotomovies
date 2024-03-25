package com.sapient.gotomovies.payment.data;

import java.util.UUID;

import com.sapient.gotomovies.payment.data.helper.Transaction;
import com.sapient.gotomovies.payment.enums.BankName;

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
@Table(name="net_banking_transaction")
public class NetBankingTransaction extends Transaction{

	private UUID userId;
	private double amount;
	
	@Column(name="account_number")
	private long accountNumber;
	
	@Enumerated(EnumType.STRING)
	@Column(name="bank_name")
	private BankName bankName;
	
	private String description;
}
