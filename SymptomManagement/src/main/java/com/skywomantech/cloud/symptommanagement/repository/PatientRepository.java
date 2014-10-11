package com.skywomantech.cloud.symptommanagement.repository;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skywomantech.cloud.symptommanagement.client.SymptomManagementApi;

@RepositoryRestResource(path = SymptomManagementApi.PATIENT_PATH)
public interface PatientRepository extends MongoRepository<Patient, Long>{
	
	// Find all patients with a similar name
    public Collection<Patient> findByName(
    		@Param(SymptomManagementApi.NAME_PARAMETER) String name);

}
