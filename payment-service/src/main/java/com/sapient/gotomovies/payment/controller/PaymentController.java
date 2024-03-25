package com.sapient.gotomovies.payment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.gotomovies.payment.dto.PaymentDto;
import com.sapient.gotomovies.payment.service.PaymentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/payment")
@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Bad Request"),
		@ApiResponse(responseCode = "401", description = "Unauthorized Access"),
		@ApiResponse(responseCode = "404", description = "Resource Not Found"),
		@ApiResponse(responseCode = "500", description = "Internal Server error"),
		@ApiResponse(responseCode = "200", description = "Success") })
@Tag(name = "Payment", description = "PaymentController")
@RestController
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	@Operation(summary = "Payment API")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Payment API to pay in various payment mode") })
	@PostMapping("/pay")
	public ResponseEntity<PaymentDto> pay(@RequestBody(required = true) PaymentDto paymentDto) {
		System.out.println(paymentDto);
		return new ResponseEntity<>(paymentService.pay(paymentDto), HttpStatus.OK);
	}
}
