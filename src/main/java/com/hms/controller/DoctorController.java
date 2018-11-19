package com.hms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.Checkinstate;
import com.hms.model.Checkinstatus;
import com.hms.model.DiagnosisRecord;
import com.hms.model.Employee;
import com.hms.model.PatientRecord;
import com.hms.model.Prescription;
import com.hms.service.CheckinstatusService;
import com.hms.service.DiagnosisService;
import com.hms.service.EmployeeService;
import com.hms.service.PatientRecordService;

@Controller
public class DoctorController {
	
	public DoctorController()
	{
		System.out.println("Doctor Controller");
	}

	
	@Autowired
	private DiagnosisService diagnosisservice;
	
	@Autowired
	private EmployeeService empservice;
	
	@Autowired
	private CheckinstatusService ckservice;
	
	@Autowired
	private PatientRecordService prservice;
	
	@RequestMapping(value={"/diagnosis"}, method= RequestMethod.GET)
	public ModelAndView newdiagnosis(HttpServletRequest request)
	{
		System.out.println("inside diagnosis controller ");
		ModelAndView model = new ModelAndView();		
		int vid = Integer.parseInt(request.getParameter("id"));
		System.out.println("visitid : "+ vid);
		boolean isrecord = diagnosisservice.recordExist(vid);
		
		if(isrecord)
		{
			DiagnosisRecord record = diagnosisservice.getDiagnosisRecord(vid);
			model.addObject("record",record);
		}
		else
		{
			System.out.println("Creating new record");
			DiagnosisRecord record = new DiagnosisRecord();
			record.setVisitid(vid);
			System.out.println("Created new with id: "+ record.getVisitid());
			model.addObject("record",record);
		}
		
		model.setViewName("ExaminationDiagnosisPortal");
		return model;
	}
	
	@RequestMapping(value={"/savediagnosis"},method = RequestMethod.POST)
	public ModelAndView saveDiagnosis(@ModelAttribute DiagnosisRecord record, HttpSession session)
	{
		boolean isrecord = diagnosisservice.recordExist(record.getVisitid());
		if(isrecord)
		{
			diagnosisservice.updateDiagnosisRecord(record);
		}
		else
		{
			diagnosisservice.addDiagnosisRecord(record);
		}
		
		
		//update checkinstatus
		
		Checkinstatus ck = ckservice.getCheckinRecord(record.getVisitid());
		ck.setCheckinstate(Checkinstate.DoctorChecked);
		ckservice.updateCheckinstatus(ck);
		
		//update doctor info in patientrecord
		
		Employee emp = (Employee) session.getAttribute("E");
		PatientRecord pr = prservice.getPatientRecord(record.getVisitid());
		pr.setDoctorid(emp.getId());
		prservice.updatePatientRecord(pr);
		
		ModelAndView model = new ModelAndView();
		model.addObject("id",record.getVisitid());
		model.addObject("msg","Saved successfully");
		model.setViewName("redirect:/diagnosis");
		return model;
	}
	
}
