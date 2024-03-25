package com.sapient.gotomovies.payment.mode;

import com.sapient.gotomovies.payment.data.helper.Transaction;
import com.sapient.gotomovies.payment.enums.BankName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NetBankingPayment implements PaymentMode {

	private BankName bankName; 
	private String accountNumber;
	
	@Override
	public Transaction pay(final double amount) {
		//TODO: Setup payment business logic
		return null;
	}
}
