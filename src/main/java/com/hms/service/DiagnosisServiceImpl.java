package com.hms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.DiagnosisDAO;
import com.hms.model.DiagnosisRecord;

@Service
@Transactional
public class DiagnosisServiceImpl implements DiagnosisService {
	
	@Autowired
	private DiagnosisDAO diagnosisdao;

	@Override
	public void addDiagnosisRecord(DiagnosisRecord DiagnosisRecord) {
		// TODO Auto-generated method stub
		diagnosisdao.addDiagnosisRecord(DiagnosisRecord);
	}

	@Override
	public void deleteDiagnosisRecord(Integer DiagnosisRecordId) {
		// TODO Auto-generated method stub
		diagnosisdao.deleteDiagnosisRecord(DiagnosisRecordId);
	}

	@Override
	public DiagnosisRecord updateDiagnosisRecord(DiagnosisRecord DiagnosisRecord) {
		// TODO Auto-generated method stub
		return diagnosisdao.updateDiagnosisRecord(DiagnosisRecord);
	}

	@Override
	public DiagnosisRecord getDiagnosisRecord(int id) {
		// TODO Auto-generated method stub
		return diagnosisdao.getDiagnosisRecord(id);
	}

	@Override
	public boolean recordExist(int visitid) {
		// TODO Auto-generated method stub
		return diagnosisdao.recordExist(visitid);
	}

}
