package com.sapient.gotomovies.payment.mode;

import com.sapient.gotomovies.payment.data.CardTransaction;
import com.sapient.gotomovies.payment.data.helper.Transaction;
import com.sapient.gotomovies.payment.enums.BankName;
import com.sapient.gotomovies.payment.enums.CardType;
import com.sapient.gotomovies.payment.repository.CardTransactionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CardPayment implements PaymentMode {

	private final BankName bankName;
	private final CardType cardType;
	private final long cardNumber;
	private final String description;
	private final CardTransactionRepository cardTransactionRepository;

	@Override
	public Transaction pay(final double amount) {
		final CardTransaction cardTransaction = CardTransaction.builder()
				.amount(amount)
				.bank(this.bankName.name())
				.cardNumber(this.cardNumber)
				.type(this.cardType)
				.description(this.description)
				.build();

		return this.cardTransactionRepository.save(cardTransaction);
	}
}
