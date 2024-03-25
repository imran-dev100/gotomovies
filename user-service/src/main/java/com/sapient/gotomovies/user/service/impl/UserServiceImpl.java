package com.sapient.gotomovies.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.gotomovies.user.data.dto.UserDto;
import com.sapient.gotomovies.user.data.entity.User;
import com.sapient.gotomovies.user.data.mapper.UserMapper;
import com.sapient.gotomovies.user.exception.ResourceNotFoundException;
import com.sapient.gotomovies.user.repository.UserRepository;
import com.sapient.gotomovies.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final String USER_NOT_FOUND_WITH_EMAIL = "User not found with email: %s";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDto createUser(final UserDto userDto) {
		return userMapper.convertToDto(userRepository.save(userMapper.convertToEntity(userDto)));
	}

	@Override
	public UserDto getByEmail(final String email) {
		User user = userRepository.findByEmail(email)
				.orElseThrow(() -> new ResourceNotFoundException(String.format(USER_NOT_FOUND_WITH_EMAIL, email)));
		return userMapper.convertToDto(user);
	}

}
