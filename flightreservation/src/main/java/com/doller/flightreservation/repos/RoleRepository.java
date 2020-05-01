package com.doller.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doller.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
