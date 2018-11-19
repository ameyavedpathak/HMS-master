package com.hms.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hms.dao.VitalsRecordDAO;
import com.hms.model.VitalsRecord;


@Service
@Transactional
public class VitalsRecordServiceImpl implements VitalsRecordService{
	
	@Autowired
	private VitalsRecordDAO vrdao;

	@Override
	public void addRecord(VitalsRecord obj) {
		// TODO Auto-generated method stub
		vrdao.addRecord(obj);
	}

	@Override
	public List<VitalsRecord> getAllRecords() {
		// TODO Auto-generated method stub
		return vrdao.getAllRecords();
	}

	@Override
	public void deleteRecord(Integer id) {
		// TODO Auto-generated method stub
		vrdao.deleteRecord(id);
	}

	@Override
	public VitalsRecord updateRecord(VitalsRecord obj) {
		// TODO Auto-generated method stub
		return vrdao.updateRecord(obj);
	}

	@Override
	public VitalsRecord getRecord(int id) {
		// TODO Auto-generated method stub
		return vrdao.getRecord(id);
	}

	@Override
	public boolean recordExist(int visitid) {
		// TODO Auto-generated method stub
		return vrdao.recordExist(visitid);
	}

}
