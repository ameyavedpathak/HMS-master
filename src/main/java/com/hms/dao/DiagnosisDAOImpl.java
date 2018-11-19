package com.hms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.DiagnosisRecord;

@Repository
public class DiagnosisDAOImpl implements DiagnosisDAO {
	
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public void addDiagnosisRecord(DiagnosisRecord DiagnosisRecord) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().saveOrUpdate(DiagnosisRecord);
	}

	@Override
	public void deleteDiagnosisRecord(Integer DiagnosisRecordId) {
		// TODO Auto-generated method stub
		DiagnosisRecord record = (DiagnosisRecord) sessionfactory.getCurrentSession().load(DiagnosisRecord.class, DiagnosisRecordId);
		if(record != null)
		{
			sessionfactory.getCurrentSession().delete(record);
		}
		
	}

	@Override
	public DiagnosisRecord updateDiagnosisRecord(DiagnosisRecord DiagnosisRecord) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().update(DiagnosisRecord);
		return DiagnosisRecord;
	}

	@Override
	public DiagnosisRecord getDiagnosisRecord(int id) {
		// TODO Auto-generated method stub
		return (DiagnosisRecord) sessionfactory.getCurrentSession().get(DiagnosisRecord.class, id);
	}

	@Override
	public boolean recordExist(int visitid) {
		// TODO Auto-generated method stub
		String sql = "from DiagnosisRecord where visitid=?";
		List<DiagnosisRecord> recordlist = sessionfactory.getCurrentSession().createQuery(sql).setParameter(0, visitid).list();
		if(!recordlist.isEmpty())
		{
			System.out.println("Diagnosis Record exists");
			return true;
		}
		System.out.println("Record does not exist");
		return false;
	}

}
