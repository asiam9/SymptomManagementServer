package com.skywomantech.cloud.symptommanagement.repository;
import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import com.skywomantech.cloud.symptommanagement.client.SymptomManagementApi;

@RepositoryRestResource(path = SymptomManagementApi.MEDICATION_PATH)
public interface MedicationRepository extends MongoRepository<Medication, Long>{

		// Find all medications with a similar name
		public Collection<Medication> findByName(
						@Param(SymptomManagementApi.NAME_PARAMETER) String name);
		
}
