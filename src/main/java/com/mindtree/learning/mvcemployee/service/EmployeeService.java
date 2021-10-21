package com.mindtree.learning.mvcemployee.service;

import java.util.List;

import com.mindtree.learning.mvcemployee.dto.EmployeeDto;
import com.mindtree.learning.mvcemployee.exception.serviceexception.ServiceException;

public interface EmployeeService {

	public EmployeeDto addEmployee(EmployeeDto employeeDto) throws ServiceException;
	
	public List<EmployeeDto> getEmployeesByDepartmentId(int dId) throws ServiceException;
}
