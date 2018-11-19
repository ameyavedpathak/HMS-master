package com.hms.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hms.model.Employee;
import com.hms.service.EmployeeService;

@Controller
public class AdminEmployeeController {

	public AdminEmployeeController() {
		System.out.println("Admin Employee Controller");
	}

	@Autowired
	private EmployeeService employeeService;



	@RequestMapping(value ={"/newEmployee"}, method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model) {
		Employee employee = new Employee();
		model.addObject("employee", employee);
		model.setViewName("AdminEmployeeManage");
		return model;
	}


	@RequestMapping(value ={"/saveEmployee"}, method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
		if (employee.getId() == 0) { // if employee id is 0 then creating the
			// employee other updating the employee
			employeeService.addEmployee(employee);
		} else {
			employeeService.updateEmployee(employee);
		}
		return new ModelAndView("redirect:/manageemployee");
	}

	@RequestMapping(value = {"/deleteEmployee"}, method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		employeeService.deleteEmployee(employeeId);
		return new ModelAndView("redirect:/manageemployee");
	}

	@RequestMapping(value = {"/editEmployee"}, method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request) {
		int employeeId = Integer.parseInt(request.getParameter("id"));
		Employee employee = employeeService.getEmployee(employeeId);
		ModelAndView model = new ModelAndView("AdminEmployeeManage");
		model.addObject("employee", employee);

		return model;
	}

}
