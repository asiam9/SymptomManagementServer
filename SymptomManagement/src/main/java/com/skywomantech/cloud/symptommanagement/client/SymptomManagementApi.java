package com.skywomantech.cloud.symptommanagement.client;


import java.util.Collection;

import com.skywomantech.cloud.symptommanagement.repository.Medication;
import com.skywomantech.cloud.symptommanagement.repository.Alert;
import com.skywomantech.cloud.symptommanagement.repository.Patient;
import com.skywomantech.cloud.symptommanagement.repository.Physician;
import com.skywomantech.cloud.symptommanagement.repository.UserCredential;

import retrofit.http.Body;
import retrofit.http.DELETE;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.PUT;
import retrofit.http.Path;
import retrofit.http.Query;

/**
 * This interface defines an API for the Symptom Management Service. The
 * interface is used to provide a contract for client/server interactions. 
 * The interface is annotated with Retrofit annotations for the benefit of clients
 */
public interface SymptomManagementApi {
	
	public static final String TOKEN_PATH = "/oauth/token";
	
	public static final String PATIENT_PATH = "/patient";
	public static final String PHYSICIAN_PATH = "/physician";
	public static final String MEDICATION_PATH = "/medication";
	public static final String ALERT_PATH = "/alert";
	public static final String CREDENTIAL_PATH = "/credential";
	
	public static final String NAME_PARAMETER = "name";
	public static final String ID_PATH = "/{id}";
	public static final String ID_PARAMETER = "id";
	
	public static final String SEARCH_PATH = "/find";
	public static final String PATIENT_SEARCH_PATH = PATIENT_PATH + SEARCH_PATH;
	public static final String PHYSICIAN_SEARCH_PATH = PHYSICIAN_PATH + SEARCH_PATH;
	public static final String MEDICATION_SEARCH_PATH = MEDICATION_PATH + SEARCH_PATH;
	public static final String CREDENTIAL_SEARCH_PATH = CREDENTIAL_PATH + SEARCH_PATH;

	
	// access any severe patients via /physician/{id}/notification
	public static final String PHYSICIAN_ALERT_PATH = PHYSICIAN_PATH + ID_PATH + ALERT_PATH;
	

	// BEGIN Patient
	
	@GET(PATIENT_PATH)
	public Collection<Patient> getPatientList();
	
	@GET(PATIENT_PATH+ID_PATH)
	public Patient getPatient(@Path(ID_PARAMETER) String id);		
	
	@POST(PATIENT_PATH)
	public Patient addPatient(@Body Patient patient);
	
	@PUT(PATIENT_PATH+ID_PATH)
	public Patient updatePatient(@Path(ID_PARAMETER) String id, @Body Patient patient);		

	@DELETE(PATIENT_PATH+ID_PATH)
	public Patient deletePatient(@Path(ID_PARAMETER) String id);		
	
	@GET(PATIENT_SEARCH_PATH)
	public Collection<Patient> findByPatientLastName(@Query(NAME_PARAMETER) String lastName);
	
	// BEGIN Physician
	
	@GET(PHYSICIAN_PATH)
	public Collection<Physician> getPhysicianList();
	
	@GET(PHYSICIAN_PATH+ID_PATH)
	public Physician getPhysician(@Path(ID_PARAMETER) String id);
	
	@POST(PHYSICIAN_PATH)
	public Physician addPhysician(@Body Physician physician);
	
	@PUT(PHYSICIAN_PATH+ID_PATH)
	public Physician updatePhysician(@Path(ID_PARAMETER) String id, @Body Physician physician);	
	
	@DELETE(PHYSICIAN_PATH+ID_PATH)
	public Physician deletePhysician(@Path(ID_PARAMETER) String userId);
	
	@GET(PHYSICIAN_SEARCH_PATH)
	public Collection<Physician> findByPhysicianLastName(@Query(NAME_PARAMETER) String lastName);
	
	@GET(PHYSICIAN_ALERT_PATH)
	public Collection<Alert> getPatientAlerts(@Path(ID_PARAMETER) String id);
	
	// BEGIN Alert
	
	@GET(ALERT_PATH)
	public Collection<Alert> getAlertList();
	
	@POST(ALERT_PATH)
	public Alert addAlert(@Body Alert alert);
	
	@DELETE(ALERT_PATH+ID_PATH)
	public Alert deleteAlert(@Path(ID_PARAMETER) String alertId);
	
	// BEGIN Medication
	
	@GET(MEDICATION_PATH+ID_PATH)
	public Medication getMedication(@Path(ID_PARAMETER) String id);
	
	@GET(MEDICATION_PATH)
	public Collection<Medication> getMedicationList();
	
	@POST(MEDICATION_PATH)
	public Medication addMedication(@Body Medication medication);
	
	@PUT(MEDICATION_PATH+ID_PATH)
	public Medication updateMedication(@Path(ID_PARAMETER) String id, @Body Medication medication);	
	
	@DELETE(MEDICATION_PATH+ID_PATH)
	public Medication deleteMedication(@Path(ID_PARAMETER) String id);
	
	@GET(MEDICATION_SEARCH_PATH)
	public Collection<Medication> findByMedicationName(@Query(NAME_PARAMETER) String name);
	
	// BEGIN Credential
	@GET(CREDENTIAL_SEARCH_PATH)
	public Collection<UserCredential> findByUserName(@Query(NAME_PARAMETER) String username);
	
	
	
}
