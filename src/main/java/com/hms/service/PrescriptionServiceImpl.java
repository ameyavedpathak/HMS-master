package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.PrescriptionDAO;
import com.hms.model.Prescription;

@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService{
	
	@Autowired
	private PrescriptionDAO pdao;

	@Override
	public void addPrescription(Prescription p) {
		// TODO Auto-generated method stub
		pdao.addPrescription(p);
	}

	@Override
	public List<Prescription> getAllPrescriptionforvisitid(int pid) {
		// TODO Auto-generated method stub
		return pdao.getAllPrescriptionforvisitid(pid);
	}

	@Override
	public Prescription updatePrescription(Prescription p) {
		// TODO Auto-generated method stub
		return pdao.updatePrescription(p);
	}

	@Override
	public boolean isPrescribed(int visitid) {
		// TODO Auto-generated method stub
		return pdao.isPrescribed(visitid);
	}

}
