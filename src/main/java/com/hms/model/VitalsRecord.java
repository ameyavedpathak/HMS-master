package com.hms.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "vitalsrecord")
public class VitalsRecord implements Serializable {

	@Id
	@Column
	private int visitid;
	
	@Column
	private double height;
	
	@Column
	private double weight;
	
	@Column
	private double temperature;
	
	@Column
	private double bloodpressure;
	
	@Column
	private boolean smokingstatus;
	
	@Column
	private String allergies;
	
	@Column
	private String symptoms;

	public int getVisitid() {
		return visitid;
	}

	public void setVisitid(int visitid) {
		this.visitid = visitid;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getTemperature() {
		return temperature;
	}

	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}

	public double getBloodpressure() {
		return bloodpressure;
	}

	public void setBloodpressure(double bloodpressure) {
		this.bloodpressure = bloodpressure;
	}

	public boolean isSmokingstatus() {
		return smokingstatus;
	}

	public void setSmokingstatus(boolean smokingstatus) {
		this.smokingstatus = smokingstatus;
	}

	public String getAllergies() {
		return allergies;
	}

	public void setAllergies(String allergies) {
		this.allergies = allergies;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	
	
	
	
	
	
	
	
}
