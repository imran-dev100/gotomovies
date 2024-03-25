package com.sapient.gotomovies.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.gotomovies.user.data.dto.UserDto;
import com.sapient.gotomovies.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RequestMapping("/user")
@ApiResponses(value = { @ApiResponse(responseCode = "400", description = "Bad Request"),
		@ApiResponse(responseCode = "401", description = "Unauthorized Access"),
		@ApiResponse(responseCode = "404", description = "Resource Not Found"),
		@ApiResponse(responseCode = "500", description = "Internal Server error"),
		@ApiResponse(responseCode = "200", description = "Success") })
@Tag(name = "User", description = "UserController")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(summary = "Login using google authentication")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "API to login using google authentication") })
	@GetMapping("/login")
	public ResponseEntity<UserDto> login(@AuthenticationPrincipal OAuth2User principal) {
		final String email = (String) principal.getAttributes().get("email");
		return new ResponseEntity<>(userService.getByEmail(email), HttpStatus.OK);
	}

	@Operation(summary = "Create new user")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "API to create new user") })
	@PostMapping("/new-user")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
		return new ResponseEntity<>(userService.createUser(dto), HttpStatus.OK);
	}
}