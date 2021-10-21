package com.mindtree.learning.mvcemployee.service;

import java.util.List;

import com.mindtree.learning.mvcemployee.dto.DepartmentDto;
import com.mindtree.learning.mvcemployee.exception.serviceexception.ServiceException;

public interface DepartmentService {

	public DepartmentDto addDepartment(DepartmentDto departmentDto) throws ServiceException;
	
	public List<DepartmentDto> getAllDepartment() throws ServiceException;
	
	public List<String> getAllDepartmentNames() throws ServiceException;
	
	public DepartmentDto getDepartmentByName(String dName) throws ServiceException;
}
