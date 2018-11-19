package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.PatientDAO;
import com.hms.model.Patient;

@Service
@Transactional
public class PatientServiceImpl implements PatientService
{
    @Autowired
	private PatientDAO patientdao;
	
	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		patientdao.addPatient(patient);
	}

	@Override
	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientdao.getAllPatient();
	}

	@Override
	public void deletePatient(Integer patientId) {
		// TODO Auto-generated method stub
		patientdao.deletePatient(patientId);
	}

	@Override
	public Patient getPatient(int patientid) {
		// TODO Auto-generated method stub
		return patientdao.getPatient(patientid);
	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		return patientdao.updatePatient(patient);
	}

	@Override
	public Boolean is_Patient(int patientid, String Password) {
		// TODO Auto-generated method stub
		return patientdao.is_Patient(patientid, Password);
	}

	@Override
	public Patient searchpatient(String firstname, String lastname, int phoneno) {
		// TODO Auto-generated method stub
		System.out.println("earch Patient Service");
		return patientdao.searchpatient(firstname, lastname, phoneno);
	}

}
