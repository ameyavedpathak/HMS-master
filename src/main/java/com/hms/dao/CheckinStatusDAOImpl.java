package com.hms.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hms.model.Checkinstatus;
import com.hms.model.Employee;

@Repository
public class CheckinStatusDAOImpl implements CheckinStatusDAO{


	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCheckinstatus(Checkinstatus Checkinstatus) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().save(Checkinstatus);
	}

	@Override
	public List<Checkinstatus> getAllCheckinstatuss() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("from Checkinstatus").list() ;
	}

	@Override
	public void deleteCheckinstatus(Integer visitid) {
		// TODO Auto-generated method stub
		Checkinstatus cs = (Checkinstatus) sessionFactory.getCurrentSession().load(
				Checkinstatus.class, visitid);
		if (null != cs) {
			this.sessionFactory.getCurrentSession().delete(cs);
		}

	}

	@Override
	public Checkinstatus updateCheckinstatus(Checkinstatus Checkinstatus) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().update(Checkinstatus);
		return Checkinstatus;
	}

	@Override
	public Checkinstatus getCheckinrecord(int visitid) {
		// TODO Auto-generated method stub
		return (Checkinstatus)sessionFactory.getCurrentSession().load(Checkinstatus.class, visitid);
	}



}
