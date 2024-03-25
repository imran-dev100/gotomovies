package com.sapient.gotomovies.payment.dto;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sapient.gotomovies.payment.enums.BankName;
import com.sapient.gotomovies.payment.enums.CardType;
import com.sapient.gotomovies.payment.enums.PaymentType;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class PaymentDto extends BaseAuditDto{

	@JsonProperty("transaction_id")
	private String transactionId;
	
	@JsonProperty("payment_type")
	private PaymentType paymentType;
	
	private double amount;

	@JsonProperty("user_id")
	private UUID userId;

	@JsonProperty("bank_name")
	private BankName bankName;

	@JsonProperty("card_type")
	private CardType cardType;

	@JsonProperty("card_number")
	private Long cardNumber;

	@JsonProperty("account_number")
	private Long accountNumber;

	@JsonProperty("mobile_number")
	private Long mobileNumber;

	@JsonProperty("pay_later_platform")
	private String payLaterPlatform;

	@Column(name = "upi_id")
	private Long upiId;

	@Column(name = "wallet_id")
	private Long walletId;

	@Column(name = "service_provider")
	private String serviceProvider;

	private String description;
}
