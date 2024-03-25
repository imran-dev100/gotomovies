package com.sapient.gotomovies.user.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sapient.gotomovies.user.data.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

	public Optional<User> findByEmail(String email);
}
