package com.mindtree.learning.mvcemployee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mindtree.learning.mvcemployee.dto.DepartmentDto;
import com.mindtree.learning.mvcemployee.exception.controllerexception.ControllerException;
import com.mindtree.learning.mvcemployee.exception.serviceexception.ServiceException;
import com.mindtree.learning.mvcemployee.service.DepartmentService;
import com.mindtree.learning.mvcemployee.service.impl.DepartmentServiceImpl;


@Controller
@RequestMapping("/department")
public class DepartmentController {

	@Autowired
	private DepartmentService ds = new DepartmentServiceImpl();
	
	@RequestMapping("/add")
	public String addDepartmentCall(Model model)
	{
		DepartmentDto departmentDto =  new DepartmentDto();
		
		model.addAttribute("department",departmentDto);
		
		return "add-department";
	}
	
	@RequestMapping("/add-submit")
	public String newDepartmentSubmission(@ModelAttribute("department") DepartmentDto departmentDto, Model model)throws ControllerException
	{
		try {
			
			departmentDto = ds.addDepartment(departmentDto);
			
		} catch (ServiceException e) {
			
			throw new ControllerException(e.getMessage());
			
		}
		
		model.addAttribute("department", departmentDto);
		
		return "add-department-success";
	}
	
	@RequestMapping("/get-all-departments")
	public String getAllDepartments(Model model)throws ControllerException
	{
		List<DepartmentDto> departments = null;
		
		try {
			
			departments = ds.getAllDepartment();
			
		} catch (ServiceException e) {
		
			throw new ControllerException(e.getMessage());
		
		}
	
		model.addAttribute("departments", departments);
		
		return "show-departments";
		
	}
	

	@RequestMapping("/get-department-names")
	@ResponseBody
	public List<String> getDepartmentName() throws ControllerException
	{
		List<String> dNames = null;
		
		try {
			
			dNames = ds.getAllDepartmentNames();
			
		} catch (ServiceException e) {
			throw new ControllerException(e.getMessage());
		}
		
		return dNames;
	}
	
	
}
