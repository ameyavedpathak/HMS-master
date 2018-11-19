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
import com.hms.service.PatientService;



@Controller
@SessionAttributes("E") 
public class FrontDeskRegisterPatientController {

	private static final Logger logger = Logger.getLogger(FrontDeskRegisterPatientController.class);	

	FrontDeskRegisterPatientController()
	{
		System.out.println("RegisterPatient Controller");
	}


	@Autowired
	private PatientService patientservice;

	@ModelAttribute("E")
	public Employee setBean()
	{
		return new Employee();		

	}

	/**
	 * Directs to FrontDeskRegister page to get the details of patients to and
	 * to register the patient into the system
	 * */
	@RequestMapping(value = {"/register"}, method = RequestMethod.GET)
	public ModelAndView regiternewpatient(HttpServletRequest request, HttpSession session)
	{

		Employee E = (Employee) session.getAttribute("E");
		System.out.println("Session details" + E.getFirstname() + " "+ E.getLastname());
		Patient patient = new Patient();
		ModelAndView model = new ModelAndView();
		model.addObject("E",E);
		model.addObject(patient);
		model.setViewName("FrontDeskRegisterPatient");
		return model;

	}


	@RequestMapping(value ="/savePatient", method = RequestMethod.POST)
	public ModelAndView savePatient(@ModelAttribute Patient patient) {
		if (patient.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			patientservice.addPatient(patient);
		} else {
			patientservice.updatePatient(patient);
		}
		ModelAndView model = new ModelAndView();
		model.addObject("msg","Patient Record Saved Successfully");
		model.setViewName("FrontDeskRegisterPatient");
		return model;
	}




}
