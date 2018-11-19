package com.hms.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.Checkinstatus;
import com.hms.model.Employee;
import com.hms.model.Patient;
import com.hms.model.PatientRecord;
import com.hms.service.CheckinstatusService;
import com.hms.service.EmployeeService;
import com.hms.service.PatientRecordService;
import com.hms.service.PatientRecordServiceImpl;
import com.hms.service.PatientService;

@Controller
@SessionAttributes("E") //we inform the controller to treat our employee as session-scoped 
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);


	public LoginController()
	{
		System.out.println("LoginController");
	}


	@Autowired
	private EmployeeService empservice;

	@Autowired
	private PatientRecordService prsservice;

	@Autowired
	private PatientService paservice;
	
	@Autowired 
	private CheckinstatusService checkinservice;


	//we declare our bean by providing a method on the controller
	@ModelAttribute("E")
	public Employee setBean()
	{
		return new Employee();		

	}


	@RequestMapping(value= "/")
	public ModelAndView LoginPage(ModelAndView model) throws IOException
	{
		model.setViewName("index");
		model.addObject("employee",new Employee());
		return model;
	}



	@SuppressWarnings("null")
	@RequestMapping(value= {"/home","*/home"})
	public ModelAndView dologin(@ModelAttribute("E") Employee emp,HttpSession session) 
	{
		ModelAndView model = new ModelAndView();		
		System.out.println("Into Dologin controller : == "+emp.getId()+"," +emp.getPassword());


		boolean is_valid = empservice.is_Employee(emp.getId(),emp.getPassword());

		if(is_valid)
		{
			System.out.println("profile:"+ emp.getId());
			Employee employee = empservice.getEmployee(emp.getId());
			if(employee.getProfile().toString().equals("Other"))
			{
				System.out.println("profile : "+employee.getProfile().toString());
				model.addObject("E",employee );
				List<Checkinstatus> cslist = checkinservice.getAllCheckinstatuss();
				System.out.println("sucess");	

				List<Patient> patientlist = new ArrayList<Patient>();
				List<PatientRecord> prlist = new ArrayList<PatientRecord>();
				Iterator<Checkinstatus> it = cslist.iterator();
				while(it.hasNext())
				{
					//System.out.println("inside while loop"+ it.next());
					Checkinstatus cs = it.next();
					PatientRecord pr= prsservice.getPatientRecord(cs.getVisitid());
					Patient P = paservice.getPatient(pr.getPid());
					patientlist.add(P);
					prlist.add(pr);
				}

				System.out.println(patientlist);


				model.addObject("prl",prlist);	
				model.addObject("patlist",patientlist);
				model.setViewName("FrontDeskHomepage");
				session.setAttribute("E", employee);
				return model;
			}
			else if(employee.getProfile().toString().equals("Doctor") || employee.getProfile().toString().equals("Nurse")) 
			{
				System.out.println("profile: "+ employee.getProfile());
				model.addObject("E",employee);
				List<Checkinstatus> checkinpatlist = checkinservice.getAllCheckinstatuss();
				List<Patient> palist = new ArrayList<Patient>();
				List<Employee> takencarebynurse =new ArrayList<Employee>();
				List<Employee> takencarebydoctor = new ArrayList<Employee>();
//				HashMap<Employee, Employee> examgroup = new HashMap<Employee,Employee>();
//				Map<PatientRecord,HashMap<Employee,Employee>> prlist = new HashMap<PatientRecord,HashMap<Employee,Employee>>();
				Iterator<Checkinstatus> li = checkinpatlist.iterator();
				while(li.hasNext())
				{
					Checkinstatus cs = li.next();
					PatientRecord pr = prsservice.getPatientRecord(cs.getVisitid());
					Patient pat = paservice.getPatient(pr.getPid());
					takencarebynurse.add(empservice.getEmployee(pr.getNurseid()));
					takencarebydoctor.add(empservice.getEmployee(pr.getDoctorid()));
					palist.add(pat);
				}
				
				model.addObject("nurse",takencarebynurse);
				model.addObject("doctor",takencarebydoctor);
				model.addObject("checkinlist",checkinpatlist);
				model.addObject("patlist",palist);
				model.setViewName("ExaminationHomepage");
				session.setAttribute("E", employee);
				return model;			
				
			}
			else if(employee.getProfile().toString().equals("Admin")) 
			{
				System.out.println("profile: "+ employee.getProfile());
				model.addObject("E",employee);
				model.setViewName("AdminHomepage");
				session.setAttribute("E", employee);
				return model;			
				
			}
		}
		System.out.println("Inside do login method of login controller and credentials are not valid");
		model.addObject("msg","Invalid Username and Password. Please try again!");
		model.addObject("employee",new Employee());
		model.setViewName("index");
		return model;

	}

	@RequestMapping("/logout")
	public String logout(HttpSession session ) 
	{

		session.invalidate();
		return "redirect:/";
	}


}
