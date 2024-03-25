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
@Table(name="pay_later_transaction")
public class PayLaterTransaction extends Transaction{

	private UUID userId;
	private double amount;
	
	@Column(name="mobile_number")
	private long mobileNumber;
	
	@Column(name="pay_later_platform")
	private String payLaterPlatform;
	
	private String description;
}
