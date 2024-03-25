package com.sapient.gotomovies.user.data.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sapient.gotomovies.user.data.dto.UserDto;
import com.sapient.gotomovies.user.data.entity.User;

@Component
public class UserMapper {

	public User convertToEntity(final UserDto dto) {
		return User.builder()
				.id(dto.getId())
				.email(dto.getEmail())
				.name(dto.getEmail())
				.phone(dto.getPhone())
				.role(dto.getRole())
				.build();
	}

	public UserDto convertToDto(final User entity) {
	   final UserDto dto = UserDto.builder()
				.id(entity.getId())
				.email(entity.getEmail())
				.name(entity.getEmail())
				.phone(entity.getPhone())
				.role(entity.getRole())
				.build();
	 
	 dto.setCreatedBy(entity.getCreatedBy());
	 dto.setUpdatedBy(entity.getUpdatedBy());
	 dto.setCreatedAt(entity.getCreatedAt());
	 dto.setUpdatedAt(entity.getUpdatedAt());
	 return dto;
	}

	public List<UserDto> convertToDto(final List<User> entities) {
		return entities.stream().map(this::convertToDto).toList();
	}
}
