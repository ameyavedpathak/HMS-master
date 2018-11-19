package com.hms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.Employee;
import com.hms.model.Patient;

@Repository
public class PatientDAOImpl implements PatientDAO
{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public void addPatient(Patient patient) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(patient);
	}

	@Override
	public List<Patient> getAllPatient(){
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from patient").list();
	}

	@Override
	public void deletePatient(Integer patientid) {
		// TODO Auto-generated method stub
		Patient patient = (Patient) sessionFactory.getCurrentSession().load(
				Patient.class, patientid);
		if (null != patient) {
			this.sessionFactory.getCurrentSession().delete(patient);
		}

	}

	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
	 sessionFactory.getCurrentSession().update(patient);
	 return patient;
	}

	@Override
	public Patient getPatient(int patientid) {
		// TODO Auto-generated method stub
		return (Patient) sessionFactory.getCurrentSession().get(Patient.class, patientid);
	}

	@Override
	public Boolean is_Patient(int patientid, String Password) {
		// TODO Auto-generated method stub
		String sql = "from patient e where p.id = ? and p.password=? ";
	    List P = sessionFactory.getCurrentSession().createQuery(sql).setParameter(0, patientid).setString(1, Password).list();
		System.out.println("Inside employee validator and got the result");
		if(!P.isEmpty())
		{
			System.out.println("Got the validator result true");
			return true;
		}
		System.out.println("Got validator result false");
		return false;
	}

	
}
