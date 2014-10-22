package com.skywomantech.cloud.symptommanagement.repository;

import java.math.BigInteger;

import org.springframework.data.annotation.Id;


public class PainLog {
	
	public enum Severity {
		NOT_DEFINED, WELL_CONTROLLED, MODERATE, SEVERE
	}
	
	public enum Eating {
		NOT_DEFINED, EATING, SOME_EATING, NOT_EATING
	}
	
	@Id
	private BigInteger id;
	private long created;
	private Severity severity = Severity.NOT_DEFINED;
	private Eating eating = Eating.NOT_DEFINED;

	public PainLog() {
		super();
	}
	
	public PainLog(Severity severity, Eating eating) {
		this.severity = severity;
		this.eating = eating;
		this.created = 0L;
	}
	
	public PainLog(long created, Severity severity, Eating eating) {
		super();
		this.created = created;
		this.severity = severity;
		this.eating = eating;
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public Severity getSeverity() {
		return severity;
	}
	
	public void setSeverity(Severity severity) {
		this.severity = severity;
	}
	
	public Eating getEating() {
		return eating;
	}
	
	public void setEating(Eating eating) {
		this.eating = eating;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (created ^ (created >>> 32));
		result = prime * result + ((eating == null) ? 0 : eating.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((severity == null) ? 0 : severity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof PainLog))
			return false;
		PainLog other = (PainLog) obj;
		if (created != other.created)
			return false;
		if (eating != other.eating)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (severity != other.severity)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PainLog [id=" + id + ", created=" + created + ", severity="
				+ severity + ", eating=" + eating + "]";
	}

}
