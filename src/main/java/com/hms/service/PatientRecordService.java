package com.hms.service;

import java.util.List;

import com.hms.model.PatientRecord;

public interface PatientRecordService
{

	public void addRecord(PatientRecord patientrecord);

	public List<PatientRecord> getAllRecords();
	
	public List getAllPatientAndRecords();

	public void deleteRecord(Integer visitid);

	public PatientRecord getPatientRecord(int visitid);


}
