package com.sapient.gotomovies.payment.mode;

import com.sapient.gotomovies.payment.data.helper.Transaction;

public interface PaymentMode {
	public Transaction pay(double amount);
}
