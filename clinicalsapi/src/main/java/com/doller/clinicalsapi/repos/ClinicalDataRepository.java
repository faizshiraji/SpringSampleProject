package com.doller.clinicalsapi.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doller.clinicalsapi.model.ClinicalData;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Integer> {

}
