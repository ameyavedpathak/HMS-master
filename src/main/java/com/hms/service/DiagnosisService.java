package com.hms.service;

import com.hms.model.DiagnosisRecord;

public interface DiagnosisService {
	
public void addDiagnosisRecord(DiagnosisRecord DiagnosisRecord);
	
	public void deleteDiagnosisRecord(Integer DiagnosisRecordId);

	public DiagnosisRecord updateDiagnosisRecord(DiagnosisRecord DiagnosisRecord);

	public DiagnosisRecord getDiagnosisRecord(int id);
	
	public boolean recordExist(int visitid);
	

}
