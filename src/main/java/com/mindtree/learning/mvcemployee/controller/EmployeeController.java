package com.mindtree.learning.mvcemployee.controller;


import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mindtree.learning.mvcemployee.dto.DepartmentDto;
import com.mindtree.learning.mvcemployee.dto.EmployeeDto;
import com.mindtree.learning.mvcemployee.editor.DepartmentDtoEditor;
import com.mindtree.learning.mvcemployee.exception.controllerexception.ControllerException;
import com.mindtree.learning.mvcemployee.exception.serviceexception.ServiceException;
import com.mindtree.learning.mvcemployee.service.DepartmentService;
import com.mindtree.learning.mvcemployee.service.EmployeeService;
import com.mindtree.learning.mvcemployee.service.impl.DepartmentServiceImpl;
import com.mindtree.learning.mvcemployee.service.impl.EmployeeServiceImpl;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService es = new EmployeeServiceImpl();
	
	@Autowired
	private DepartmentService ds = new DepartmentServiceImpl();
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(DepartmentDto.class,new DepartmentDtoEditor(ds) );
	}
	
	
	@RequestMapping("/add")
	public String addEmployeeCall(Model model) {
		
		EmployeeDto employeeDto = new EmployeeDto();
		
		model.addAttribute("employee", employeeDto);
		
		return "add-employee";
	}
	
	@RequestMapping("/add-submit")
	public String addEmployee(@ModelAttribute("employee") EmployeeDto employeeDto,BindingResult result, Model model) throws ControllerException
	{
		try {
			employeeDto = es.addEmployee(employeeDto);
			
		} catch (ServiceException e) {
			
			throw new ControllerException(e.getMessage());
		}
		
		model.addAttribute("employee", employeeDto);
		
		return "add-employee-success";
	}
	
	@RequestMapping(value = "/getallbydepartment/{dId}", method = RequestMethod.GET)
	public String getemployees(@PathVariable("dId") int dId, Model model) throws ControllerException
	{
		List<EmployeeDto> employees = null;
		
		try {
			
			employees  = es.getEmployeesByDepartmentId(dId);
			
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		
		model.addAttribute("employees", employees);
		
		return "show-employess";
	}
	
}
