package com.skywomantech.cloud.symptommanagement.repository;

import java.util.Set;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Patient {

	@Id
	private String id;
	private String firstName;
	private String lastName;
	private long birthdate;
	private long lastLogin;
	private Boolean active;
	
	private Set<Medication> prescriptions;
	private Set<Physician> physicians;
	
	private Set<PainLog> painLog;
	private Set<MedicationLog> medLog;
	private Set<StatusLog> statusLog;
	
	private PatientPrefs prefs;
	
	public Patient() {
		super();
	}
	
	public Patient( String firstName, String lastName ){
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = System.currentTimeMillis();
		this.active = true;
		this.lastLogin = 0L;
	}
	
	public Patient( String firstName, String lastName, long birthdate, long lastLogin,
			Boolean isActive, Set<Medication> prescriptions,
			Set<Physician> physicians, Set<PainLog> painLog,
			Set<MedicationLog> medLog, Set<StatusLog> statusLog, PatientPrefs prefs) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.lastLogin = lastLogin;
		this.active = isActive;
		this.prescriptions = prescriptions;
		this.physicians = physicians;
		this.painLog = painLog;
		this.medLog = medLog;
		this.statusLog = statusLog;
		this.prefs = prefs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public String getName() {
		return lastName + ", " + firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(long birthdate) {
		this.birthdate = birthdate;
	}

	public long getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(long lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Boolean isActive() {
		return active;
	}

	public void setIsActive(Boolean isActive) {
		this.active = isActive;
	}

	public Set<Medication> getPrescriptions() {
		return prescriptions;
	}
	
	public void setPrescriptions(Set<Medication> prescriptions) {
		this.prescriptions = prescriptions;
	}
	
	public Set<Physician> getPhysicians() {
		return physicians;
	}
	
	public void setPhysicians(Set<Physician> physicians) {
		this.physicians = physicians;
	}
	
	public Set<PainLog> getPainLog() {
		return painLog;
	}
	
	public void setPainLog(Set<PainLog> painLog) {
		this.painLog = painLog;
	}
	
	public Set<MedicationLog> getMedLog() {
		return medLog;
	}
	
	public void setMedLog(Set<MedicationLog> medLog) {
		this.medLog = medLog;
	}
	
	public Set<StatusLog> getStatusLog() {
		return statusLog;
	}
	
	public void setStatusLog(Set<StatusLog> statusLog) {
		this.statusLog = statusLog;
	}

	public PatientPrefs getPrefs() {
		return prefs;
	}

	public void setPrefs(PatientPrefs prefs) {
		this.prefs = prefs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (birthdate ^ (birthdate >>> 32));
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Patient))
			return false;
		Patient other = (Patient) obj;
		if (birthdate != other.birthdate)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", birthdate=" + birthdate + ", lastLogin="
				+ lastLogin + ", active=" + active + ", prescriptions="
				+ prescriptions + ", physicians=" + physicians + ", painLog="
				+ painLog + ", medLog=" + medLog + ", statusLog=" + statusLog
				+ ", prefs=" + prefs + "]";
	}

	
}
