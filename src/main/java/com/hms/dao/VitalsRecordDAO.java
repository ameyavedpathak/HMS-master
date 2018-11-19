package com.hms.dao;

import java.util.List;

import com.hms.model.VitalsRecord;

public interface VitalsRecordDAO {

	public void addRecord(VitalsRecord obj);

	public List<VitalsRecord> getAllRecords();

	public void deleteRecord(Integer id);

	public VitalsRecord updateRecord(VitalsRecord obj);

	public VitalsRecord getRecord(int id);
	
	public boolean recordExist(int visitid);
	
	
	
}
