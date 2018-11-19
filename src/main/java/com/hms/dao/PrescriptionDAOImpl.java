package com.hms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.Prescription;

@Repository
public class PrescriptionDAOImpl implements PrescriptionDAO{

	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void addPrescription(Prescription p) {
		// TODO Auto-generated method stub
		System.out.println("Adding prescription details to db");
		sessionfactory.getCurrentSession().save(p);
		System.out.println("Added data ");
	}

	@Override
	public List<Prescription> getAllPrescriptionforvisitid(int pid) {
		// TODO Auto-generated method stub

		String sql = "from Prescription where visitid=?";
		List<Prescription> plist = sessionfactory.getCurrentSession().createQuery(sql).setParameter(0, pid).list();
		return plist;
	}

	@Override
	public Prescription updatePrescription(Prescription p) {
		// TODO Auto-generated method stub

		sessionfactory.getCurrentSession().update(p);		
		return p;
	}

	@Override
	public boolean isPrescribed(int pid) {
		// TODO Auto-generated method stub
		String sql = "from Prescription where visitid=?";
		List<Prescription> plist = sessionfactory.getCurrentSession().createQuery(sql).setParameter(0, pid).list();
		if(!plist.isEmpty())
		{
			return true;
		}		
		return false;
	}





}
