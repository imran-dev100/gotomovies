package com.sapient.gotomovies.user.data.dto;

import java.util.UUID;

import com.sapient.gotomovies.user.enums.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto extends BaseAuditDto{

	private UUID id;
	private String name;
	private String email;
	private String phone;
	private Role role;
}
