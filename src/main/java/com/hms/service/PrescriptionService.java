package com.hms.service;

import java.util.List;

import com.hms.model.Prescription;

public interface PrescriptionService {
	
public void addPrescription(Prescription p);
	
	public List<Prescription> getAllPrescriptionforvisitid(int pid);
	
	public Prescription updatePrescription(Prescription p);
	
	public boolean isPrescribed(int visitid);

}
