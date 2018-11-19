package com.hms.controller;

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
import com.hms.service.PatientService;

@Controller
@SessionAttributes("E") 
public class FrontdeskHomepageController {

	private static final Logger logger = Logger.getLogger(FrontdeskHomepageController.class);	


	FrontdeskHomepageController()
	{
		System.out.println("FrontDeskHomepageController");
	}

	@Autowired
	private PatientService patientservice;

	
	@ModelAttribute("E")
	public Employee setBean()
	{
		return new Employee();		

	}
	
	
	@RequestMapping(value={"/searchpatient"})
	public ModelAndView searchpatient(HttpServletRequest request)
	{
		
		String FirstName = request.getParameter("firstname");
		String LastName = request.getParameter("lastname");
		String phoneno = request.getParameter("phoneno");
		int phone = Integer.parseInt(phoneno);
		System.out.println("Inside searchpatient :" + FirstName + LastName + phone);
		Patient P = patientservice.searchpatient(FirstName, LastName, phone);
		System.out.println("Patient: "+ P.getFirstname());
		ModelAndView model = new ModelAndView();
		model.addObject("patient",P);
		model.setViewName("FrontDeskCheckinPatient");		
		return model;	
		
	}

}
