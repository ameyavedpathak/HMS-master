package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.PatientRecordDAO;
import com.hms.model.PatientRecord;


@Transactional
@Service
public class PatientRecordServiceImpl implements PatientRecordService
{

	@Autowired
	private PatientRecordDAO recorddao;
	
	@Override
	public void addRecord(PatientRecord patientrecord) {
		// TODO Auto-generated method stub
		recorddao.addRecord(patientrecord);
	}

	@Override
	public List<PatientRecord> getAllRecords() {
		// TODO Auto-generated method stub
		System.out.println("2");
		return recorddao.getAllRecords();
	}

	@Override
	public void deleteRecord(Integer visitid) {
		// TODO Auto-generated method stub
		recorddao.deleteRecord(visitid);
	}

	@Override
	public PatientRecord getPatientRecord(int visitid) {
		// TODO Auto-generated method stub
		return recorddao.getPatientRecord(visitid);
	}

	@Override
	public List getAllPatientAndRecords() {
		// TODO Auto-generated method stub
		
		return recorddao.getAllPatientAndRecords();
	}

}
