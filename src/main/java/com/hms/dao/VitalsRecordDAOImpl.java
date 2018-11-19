package com.hms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.VitalsRecord;

@Repository
public class VitalsRecordDAOImpl implements VitalsRecordDAO {

	@Autowired
	private SessionFactory sessionfactory;	

	@Override
	public void addRecord(VitalsRecord obj) {
		// TODO Auto-generated method stub
		sessionfactory.getCurrentSession().saveOrUpdate(obj);
	}

	@Override
	public List<VitalsRecord> getAllRecords() {
		// TODO Auto-generated method stub
		return sessionfactory.getCurrentSession().createQuery("from VitalsRecord").list();
	}

	@Override
	public void deleteRecord(Integer id) {
		// TODO Auto-generated method stub
		VitalsRecord vr = (VitalsRecord) sessionfactory.getCurrentSession().load(VitalsRecord.class, id);
		if(vr != null)
		{
			sessionfactory.getCurrentSession().delete(vr);	
		}
	}

	@Override
	public VitalsRecord updateRecord(VitalsRecord obj) {
		// TODO Auto-generated method stub
		System.out.println("2");
		sessionfactory.getCurrentSession().update(obj);
		System.out.println("3");		
		return obj;
	}

	@Override
	public VitalsRecord getRecord(int id) {
		// TODO Auto-generated method stub
		return (VitalsRecord) sessionfactory.getCurrentSession().get(VitalsRecord.class,id);
	}

	@Override
	public boolean recordExist(int visitid) {
		// TODO Auto-generated method stub
       
		List vrlist = sessionfactory.getCurrentSession().createQuery("from VitalsRecord where visitid=?").setParameter(0, visitid).list();
		
		if(!vrlist.isEmpty())
		{
			System.out.println("Record exists");
			return true;
		}
        return false;
	}




}
