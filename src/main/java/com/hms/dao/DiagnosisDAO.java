package com.hms.dao;
import com.hms.model.DiagnosisRecord;

public interface DiagnosisDAO {

	public void addDiagnosisRecord(DiagnosisRecord DiagnosisRecord);
	
	public void deleteDiagnosisRecord(Integer DiagnosisRecordId);

	public DiagnosisRecord updateDiagnosisRecord(DiagnosisRecord DiagnosisRecord);

	public DiagnosisRecord getDiagnosisRecord(int id);
	
	public boolean recordExist(int visitid);
	
	
}
