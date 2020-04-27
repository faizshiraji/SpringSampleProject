package com.doller.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doller.flightreservation.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	User findByEmail(String email);

}
