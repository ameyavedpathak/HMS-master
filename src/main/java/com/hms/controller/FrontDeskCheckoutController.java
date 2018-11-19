package com.hms.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.Employee;
import com.hms.model.Patient;
import com.hms.model.PatientRecord;
import com.hms.service.PatientRecordService;
import com.hms.service.PatientService;

@Controller
public class FrontDeskCheckoutController {

	private static final Logger logger = Logger.getLogger(FrontDeskCheckoutController.class);	

	FrontDeskCheckoutController()
	{
		System.out.println("FrontDeskCheckoutController");
	}


	@Autowired
	private PatientService paservice;

	@Autowired 
	private PatientRecordService prservice;


	@RequestMapping(value = {"/checkout"}, method = RequestMethod.GET)
	public ModelAndView checkout(HttpServletRequest request, HttpSession session)
	{

		Employee E = (Employee) session.getAttribute("E");
		System.out.println("Session details" + E.getFirstname() + " "+ E.getLastname());
		System.out.println("Inside Checlout Controller");
		List<PatientRecord> prlist = prservice.getAllCheckinPatient();
		List<Patient> patientlist = new ArrayList<Patient>();		
		Iterator it = prlist.iterator();
		while(it.hasNext())
		{
			PatientRecord pr = (PatientRecord) it.next();
			System.out.println(pr.getPid());
			patientlist.add(paservice.getPatient(pr.getPid()));
		}		
		System.out.println(patientlist);	
		ModelAndView model = new ModelAndView();
		model.addObject("prlist" , prlist);
		model.addObject("patlist",patientlist);
		model.addObject("E",E);
		model.setViewName("FrontDeskCheckoutPatient");
		return model;

	}


	@RequestMapping(value={"/checkoutpatient"} )
	public ModelAndView checkoutPatient(HttpServletRequest request)
	{
		ModelAndView model = new ModelAndView();
		int id = Integer.parseInt(request.getParameter("id"));
		String paymentt = request.getParameter("paymenttype");
		System.out.println(id + paymentt);
		PatientRecord pr = prservice.getPatientRecord(id);
		System.out.println(pr);
		pr.setPaymenttype(paymentt);
		PatientRecord pr2 = prservice.updatePatientRecord(pr);
		if(!pr2.equals(null))
		{
			
			model.addObject("msg","Patient is Checked out");
			model.setViewName("FrontDeskCheckoutPatient");
	
			
		}
		else
		{
			model.addObject("msg","not successfull update");
			model.setViewName("FrontDeskCheckoutPatient");
		}

		return model;


	}

}
