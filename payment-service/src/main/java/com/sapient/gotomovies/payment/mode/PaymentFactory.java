package com.sapient.gotomovies.payment.mode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.sapient.gotomovies.payment.dto.PaymentDto;
import com.sapient.gotomovies.payment.repository.CardTransactionRepository;

@Configuration
public class PaymentFactory {

	@Autowired
	private CardTransactionRepository cardTransactionRepository;

	@Bean
	@Scope(BeanDefinition.SCOPE_PROTOTYPE)
	public PaymentMode getPaymentMode(final PaymentDto paymentDto) {

		switch (paymentDto.getPaymentType()) {
		case CARD:
			return new CardPayment(paymentDto.getBankName(), paymentDto.getCardType(), paymentDto.getCardNumber(),
					paymentDto.getDescription(), cardTransactionRepository);
		case NET_BANKING:
			return new NetBankingPayment();
		case PAY_LATER:
			return new PayLaterPayment();
		case UPI:
			return new UpiPayment();
		case WALLET:
			return new WalletPayment();
		}

		throw new RuntimeException("Invalid Payment Mode");
	}
}
