package com.hms.dao;

import java.util.List;

import org.hibernate.FetchMode;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hms.model.PatientRecord;



@Repository
public class PatientRecordImpl implements PatientRecordDAO
{

	@Autowired
	private SessionFactory sessionfactory;	


	@Override
	public void addRecord(PatientRecord patientrecord) {
		// TODO Auto-generated method stub

		sessionfactory.getCurrentSession().saveOrUpdate(patientrecord);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PatientRecord> getAllRecords() {
		// TODO Auto-generated method stub
		System.out.println("3");
		return sessionfactory.getCurrentSession().createQuery("from PatientRecord").list();

	}

	@Override
	public void deleteRecord(Integer visitid) {
		// TODO Auto-generated method stub

		PatientRecord pr = (PatientRecord) sessionfactory.getCurrentSession().load(PatientRecord.class, visitid);
		if(pr != null)
		{
			sessionfactory.getCurrentSession().delete(pr);
		}
	}

	@Override
	public PatientRecord getPatientRecord(int visitid) {
		// TODO Auto-generated method stub
		return (PatientRecord) sessionfactory.getCurrentSession().get(PatientRecord.class, visitid);
	}


//	@SuppressWarnings("unchecked")
//	@Override
//	public List getAllPatientAndRecords() {
//		// TODO Auto-generated method stub
//
//		String Sql = "select firstname, visitdatetime from PatientRecord as pr, Patient as p where pr.pid = p.pid";
//		return sessionfactory.getCurrentSession().createSQLQuery(Sql).list();
//
//	}


	@SuppressWarnings("unchecked")
	@Override
	public List<PatientRecord> getAllCheckinPatient() {
		// TODO Auto-generated method stub
		System.out.println("1");
		//String sql = "select * from PatientRecord where paymenttype is NULL and DATE(visitdatetime) = DATE(SYSDATE())";		
		return sessionfactory.getCurrentSession().createQuery("from PatientRecord where paymenttype is null and DATE(visitdatetime) = DATE(sysdate())").list();
	}

	@Override
	public PatientRecord updatePatientRecord(PatientRecord pr) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().update(pr);
		return pr;
	}




}
