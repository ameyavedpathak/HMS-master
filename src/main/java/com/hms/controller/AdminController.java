package com.hms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.Employee;
import com.hms.model.Patient;
import com.hms.service.EmployeeService;
import com.hms.service.PatientService;

@Controller
@SessionAttributes("E")
public class AdminController {

	
	private static final Logger logger = Logger.getLogger(AdminController.class);	


	AdminController()
	{
		System.out.println("Admin Controller");
	}


	@Autowired
	private EmployeeService empservice;
	
	@Autowired
	private PatientService patservice;
	
	
	@ModelAttribute("E")
	public Employee setBean()
	{
		return new Employee();		

	}
	
	@RequestMapping(value= {"/admin"}, method = RequestMethod.GET)
	public ModelAndView adminHomepage(HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		Employee E = (Employee) session.getAttribute("E");
		List<Employee> emplist = empservice.getAllEmployees();
		model.setViewName("AdminHomepage");
		return model;
	}
	
	
	@RequestMapping(value= {"/manageemployee"}, method = RequestMethod.GET)
	public ModelAndView manageEmployee(HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		Employee E = (Employee) session.getAttribute("E");
		List<Employee> emplist = empservice.getAllEmployees();
		model.addObject("emplist",emplist);
		model.setViewName("AdminEmployeeHome");
		return model;
	}
	
	
	@RequestMapping(value= {"/managepatient"}, method = RequestMethod.GET)
	public ModelAndView managePatient(HttpSession session)
	{
		ModelAndView model = new ModelAndView();
		Employee E = (Employee) session.getAttribute("E");
		List<Patient> patlist = patservice.getAllPatient();
		model.addObject("patlist",patlist);
		model.setViewName("AdminPatientHome");
		return model;
	}
	
	
}
