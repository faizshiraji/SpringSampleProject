package com.doller.clinicalsapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doller.clinicalsapi.model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
