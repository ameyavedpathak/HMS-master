package com.hms.dao;

import java.util.List;
import com.hms.model.Checkinstatus;


public interface CheckinStatusDAO {
	
	public void addCheckinstatus(Checkinstatus Checkinstatus);

	public List<Checkinstatus> getAllCheckinstatuss();

	public void deleteCheckinstatus(Integer visitid);

	public Checkinstatus updateCheckinstatus(Checkinstatus Checkinstatus);
	
	public Checkinstatus getCheckinrecord(int visitid);

}
