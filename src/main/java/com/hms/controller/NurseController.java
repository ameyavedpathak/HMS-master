package com.hms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.Checkinstate;
import com.hms.model.Checkinstatus;
import com.hms.model.Employee;
import com.hms.model.Patient;
import com.hms.model.PatientRecord;
import com.hms.model.VitalsRecord;
import com.hms.service.CheckinstatusService;
import com.hms.service.PatientRecordService;
import com.hms.service.PatientService;
import com.hms.service.VitalsRecordService;

@Controller
public class NurseController {

	public NurseController()
	{
		System.out.println("Nurse Controller");
	}

	@Autowired
	private CheckinstatusService checkinservice;

	@Autowired
	private VitalsRecordService vrservice;

	@Autowired
	private PatientRecordService prservice;

	@Autowired
	private PatientService pservice;

	
	@RequestMapping(value={"/vitals"},method = RequestMethod.GET)
	public ModelAndView getVitals1(HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		
		PatientRecord pr = prservice.getPatientRecord(id);
		Patient p = pservice.getPatient(pr.getPid());
		
		boolean isrecord = vrservice.recordExist(id);
		
		if(isrecord)
		{
			model.addObject("record",vrservice.getRecord(id));
		}
		else
		{
			VitalsRecord record = new VitalsRecord();
			record.setVisitid(id);
			model.addObject("record",record);
		}
		
		model.addObject("p",p);
		model.addObject("pr",pr);
		model.setViewName("ExaminationVitalsPortal");
		return model;
	}
	
	@RequestMapping(value={"/savevitals"},method = RequestMethod.POST)
	public ModelAndView saveVitals(@ModelAttribute VitalsRecord vr, HttpSession session)
	{
		boolean isrecord = vrservice.recordExist(vr.getVisitid());
		//add vitals record to vitals record table
		if(isrecord)
		{
			System.out.println("1");
			VitalsRecord  r2 = vrservice.updateRecord(vr);
		}
		else
		{
			vrservice.addRecord(vr);
				
		}
		
		System.out.println("4");
		//change status for visit record as nurse checked in
		Checkinstatus ck = checkinservice.getCheckinRecord(vr.getVisitid());
		ck.setCheckinstate(Checkinstate.NurseChecked);
		System.out.println("5");
		//Assign nurse name into taken care by nurse in record
		Employee E = (Employee) session.getAttribute("E");
		PatientRecord pr = prservice.getPatientRecord(vr.getVisitid());
		pr.setNurseid(E.getId());
		System.out.println("6");
		prservice.updatePatientRecord(pr);		
		checkinservice.updateCheckinstatus(ck);
		
		System.out.println("Successfully saved vital details");
		
		ModelAndView model= new ModelAndView();
		model.addObject("id",vr.getVisitid());
		model.addObject("msg","Vitals Saved Successfully");
		model.setViewName("redirect:/vitals");
		return model;
	}
	
	
	
	
	
	
//	@RequestMapping(value={"/vitals"},method = RequestMethod.GET)
//	public ModelAndView getVitals(HttpServletRequest request)
//	{
//		ModelAndView model = new ModelAndView();
//		int id = Integer.parseInt(request.getParameter("id"));
//		PatientRecord pr = prservice.getPatientRecord(id);
//		Patient p = pservice.getPatient(pr.getPid());
//		VitalsRecord record = new VitalsRecord();
//		record.setVisitid(id);
//		model.addObject("record", record);
//		model.addObject("p",p);
//		model.addObject("pr",pr);
//		model.setViewName("ExaminationVitalsPortal");
//		return model;
//	}
//	
//	@RequestMapping(value={"/editvitals"}, method = RequestMethod.GET)
//	public ModelAndView editVitals(HttpServletRequest request)
//	{
//		ModelAndView model = new ModelAndView();
//		int id = Integer.parseInt(request.getParameter("id"));
//		PatientRecord pr = prservice.getPatientRecord(id);
//		Patient p = pservice.getPatient(pr.getPid());
//		model.addObject("record", vrservice.getRecord(id));
//		model.addObject("p",p);
//		model.addObject("pr",pr);
//		model.setViewName("ExaminationVitalsPortal");
//		return model;
//	}
//	
	
	


}
