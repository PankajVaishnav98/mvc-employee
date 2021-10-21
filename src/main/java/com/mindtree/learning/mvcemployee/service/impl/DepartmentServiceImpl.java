package com.mindtree.learning.mvcemployee.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.learning.mvcemployee.dto.DepartmentDto;
import com.mindtree.learning.mvcemployee.exception.serviceexception.ServiceException;
import com.mindtree.learning.mvcemployee.model.Department;
import com.mindtree.learning.mvcemployee.model.Employee;
import com.mindtree.learning.mvcemployee.repository.DepartmentRepo;
import com.mindtree.learning.mvcemployee.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepo dr;
	
	static ModelMapper mapper = new ModelMapper();

	@Override
	public DepartmentDto addDepartment(DepartmentDto departmentDto) throws ServiceException {
		Department department = mapper.map(departmentDto, Department.class);
		try {
			
			department = dr.save(department);
			
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return mapper.map(department, DepartmentDto.class);
	}

	@Override
	public List<DepartmentDto> getAllDepartment() throws ServiceException {
		List<Department> departments = new ArrayList<>();
		try {
			
			dr.findAll().forEach(departments::add);
			
			Comparator<Department> sortByName = Comparator.comparing(Department::getName);
			
			Comparator<Employee> sortByNameEmployee = Comparator.comparing(Employee::getName);
			
			departments.stream().sorted(sortByName).collect(Collectors.toList());
			
			departments.stream().map(department->department.getEmployees().stream().sorted(sortByNameEmployee).collect(Collectors.toList()));
			
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return departments.stream().map(department->mapper.map(department, DepartmentDto.class)).collect(Collectors.toList());
	}
	
	
	@Override
	public List<String> getAllDepartmentNames() throws ServiceException
	{
		List<String> dNames = null;
		try {
			
			dNames = dr.getAllDepartmentNames();
			
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return dNames;
	}

	@Override
	public DepartmentDto getDepartmentByName(String dName) throws ServiceException {
		DepartmentDto departmentDto = null;
		
		try {
			
			departmentDto = mapper.map(dr.findDepartmentByName(dName),DepartmentDto.class);
			
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		
		return departmentDto;
	}
	
}
