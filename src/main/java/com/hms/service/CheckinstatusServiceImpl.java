package com.hms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hms.dao.CheckinStatusDAO;
import com.hms.model.Checkinstatus;

@Service
@Transactional
public class CheckinstatusServiceImpl implements CheckinstatusService{

	@Autowired
	private CheckinStatusDAO checkinstatusdao;
	
	
	@Override
	public void addCheckinstatus(Checkinstatus Checkinstatus) {
		// TODO Auto-generated method stub
		checkinstatusdao.addCheckinstatus(Checkinstatus);
	}

	@Override
	public List<Checkinstatus> getAllCheckinstatuss() {
		// TODO Auto-generated method stub
		return checkinstatusdao.getAllCheckinstatuss();
	}

	@Override
	public void deleteCheckinstatus(Integer visitid) {
		// TODO Auto-generated method stub
		checkinstatusdao.deleteCheckinstatus(visitid);
	}

	@Override
	public Checkinstatus updateCheckinstatus(Checkinstatus Checkinstatus) {
		// TODO Auto-generated method stub
		return checkinstatusdao.updateCheckinstatus(Checkinstatus);
	}

	@Override
	public Checkinstatus getCheckinRecord(int visitid) {
		// TODO Auto-generated method stub
		return checkinstatusdao.getCheckinrecord(visitid);
	}

}
