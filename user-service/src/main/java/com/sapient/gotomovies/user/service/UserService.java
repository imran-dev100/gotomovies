package com.sapient.gotomovies.user.service;

import com.sapient.gotomovies.user.data.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto dto);

	UserDto getByEmail(String email);

}
