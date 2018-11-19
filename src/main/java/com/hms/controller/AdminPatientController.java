package com.hms.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.hms.model.Patient;
import com.hms.service.PatientService;

@Controller
public class AdminPatientController 
{

	public AdminPatientController()
	{
		System.out.println("Admin Patient Controller");
	}


	@Autowired
	private PatientService patientservice;



	@RequestMapping(value ={"/newPatient"}, method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Patient Patient = new Patient();
		model.addObject("Patient", Patient);
		model.setViewName("AdminPatientManage");
		return model;
	}


	@RequestMapping(value ={"/adminsavePatient"}, method = RequestMethod.POST)
	public ModelAndView savePatient(@ModelAttribute Patient Patient) {
		if (Patient.getId() == 0) { // if Patient id is 0 then creating the
			// Patient other updating the Patient
			patientservice.addPatient(Patient);
		} else {
			patientservice.updatePatient(Patient);
		}
		return new ModelAndView("redirect:/managepatient");
	}

	@RequestMapping(value = {"/deletePatient"}, method = RequestMethod.GET)
	public ModelAndView deletePatient(HttpServletRequest request) {
		int PatientId = Integer.parseInt(request.getParameter("id"));
		patientservice.deletePatient(PatientId);
		return new ModelAndView("redirect:/managepatient");
	}

	@RequestMapping(value = {"/editPatient"}, method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int PatientId = Integer.parseInt(request.getParameter("id"));
		Patient Patient = patientservice.getPatient(PatientId);
		ModelAndView model = new ModelAndView("AdminPatientManage");
		model.addObject("Patient", Patient);

		return model;
	}



}
