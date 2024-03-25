package com.sapient.gotomovies.user.data.entity;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import com.sapient.gotomovies.user.data.dto.UserDto;
import com.sapient.gotomovies.user.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity {
	
	@Id
	@UuidGenerator
	private UUID id;
	private String name;
	private String email;
	private String phone;
	
	@Enumerated(EnumType.STRING)
	private Role role;
}