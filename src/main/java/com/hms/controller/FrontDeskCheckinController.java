package com.hms.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.Employee;
import com.hms.model.Patient;
import com.hms.model.PatientRecord;
import com.hms.service.PatientRecordService;
import com.hms.service.PatientService;

@Controller
@SessionAttributes("E") 
public class FrontDeskCheckinController {

	private static final Logger logger = Logger.getLogger(FrontDeskCheckinController.class);	

	FrontDeskCheckinController()
	{
		System.out.println("Checkin Controller");
	}

	
	@Autowired
	private PatientRecordService patientrecordservice;
	
	@ModelAttribute("E")
	public Employee setBean()
	{
		return new Employee();		

	}

	@RequestMapping(value = {"/check-in"}, method = RequestMethod.GET)
	public ModelAndView checkinpatient(HttpServletRequest request, HttpSession session)
	{

		Employee E = (Employee) session.getAttribute("E");
		System.out.println("Session details" + E.getFirstname() + " "+ E.getLastname());
		ModelAndView model = new ModelAndView();
		model.addObject("E",E);
		Patient P = new Patient();
		model.addObject("patient", P);
		model.setViewName("FrontDeskCheckinPatient");
		return model;

	}
	
	@RequestMapping(value="/savecheckindetails", method= RequestMethod.POST)
	public ModelAndView savecheckin(HttpServletRequest request)
	{
		int pid = Integer.parseInt(request.getParameter("pid"));
		String reason = request.getParameter("reason");			
	    Date visitdatetime = new Date();		
		PatientRecord pr = new PatientRecord();
		pr.setPid(pid);
		pr.setReasonforvisit(reason);
		pr.setVisitdatetime(visitdatetime);
		System.out.println("Try to save record");
	    patientrecordservice.addRecord(pr);
	    System.out.println("Succesfully saved Record");
		ModelAndView model = new ModelAndView();
		model.addObject("msg","Patient with ID: "+ pid+ " is Checked in Successfully");
		model.setViewName("FrontDeskCheckinPatient");	
		return model;
	}

}
