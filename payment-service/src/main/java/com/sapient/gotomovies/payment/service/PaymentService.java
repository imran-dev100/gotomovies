package com.sapient.gotomovies.payment.service;

import com.sapient.gotomovies.payment.dto.PaymentDto;

public interface PaymentService {

	PaymentDto pay(PaymentDto paymentDto);
}
