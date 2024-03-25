package com.sapient.gotomovies.payment.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.gotomovies.payment.data.helper.Transaction;
import com.sapient.gotomovies.payment.dto.PaymentDto;
import com.sapient.gotomovies.payment.mode.PaymentFactory;
import com.sapient.gotomovies.payment.mode.PaymentMode;
import com.sapient.gotomovies.payment.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentFactory paymentFactory;

	@Transactional
	@Override
	public PaymentDto pay(final PaymentDto paymentDto) {

		final PaymentMode mode = paymentFactory.getPaymentMode(paymentDto);
		final Transaction transaction = mode.pay(paymentDto.getAmount());

		paymentDto.setTransactionId(transaction.getId().toString());
		paymentDto.setCreatedAt(transaction.getCreatedAt());
		paymentDto.setCreatedBy(transaction.getCreatedBy());
		paymentDto.setUpdatedAt(transaction.getUpdatedAt());
		paymentDto.setUpdatedBy(transaction.getUpdatedBy());

		return paymentDto;
	}
}
