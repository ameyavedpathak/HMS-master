package com.hms.service;

import java.util.List;

import com.hms.model.Checkinstatus;

public interface CheckinstatusService {
	
	public void addCheckinstatus(Checkinstatus Checkinstatus);

	public List<Checkinstatus> getAllCheckinstatuss();

	public void deleteCheckinstatus(Integer visitid);

	public Checkinstatus updateCheckinstatus(Checkinstatus Checkinstatus);
	
	public Checkinstatus getCheckinRecord(int visitid);
	


}
