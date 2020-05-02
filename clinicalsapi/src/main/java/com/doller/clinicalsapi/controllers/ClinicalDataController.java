package com.doller.clinicalsapi.controllers;

import java.util.Optional;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.doller.clinicalsapi.dto.ClinicalDataRequest;
import com.doller.clinicalsapi.model.ClinicalData;
import com.doller.clinicalsapi.model.Patient;
import com.doller.clinicalsapi.repos.ClinicalDataRepository;
import com.doller.clinicalsapi.repos.PatientRepository;

@RestController
@RequestMapping("/api")
public class ClinicalDataController {
	private ClinicalDataRepository clinicalDataRepository;
	private PatientRepository patientRepository;
	
	ClinicalDataController(ClinicalDataRepository clinicalDataRepository, PatientRepository patientRepository) {
		this.clinicalDataRepository = clinicalDataRepository;
		this.patientRepository = patientRepository;
	}
	
	@RequestMapping(value = "/clinicals", method = RequestMethod.POST)
	public ClinicalData	saveClinicalData(@RequestBody ClinicalDataRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId()).get();
		ClinicalData clinicalData = new ClinicalData();
		clinicalData.setComponentName(request.getComponentName());
		clinicalData.setPatient(patient);
		return clinicalDataRepository.save(clinicalData);
	}
	
}
