package com.mindtree.learning.mvcemployee.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.mindtree.learning.mvcemployee.dto.EmployeeDto;
import com.mindtree.learning.mvcemployee.exception.serviceexception.ServiceException;
import com.mindtree.learning.mvcemployee.model.Department;
import com.mindtree.learning.mvcemployee.model.Employee;
import com.mindtree.learning.mvcemployee.repository.EmployeeRepo;
import com.mindtree.learning.mvcemployee.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepo er;
	
	static ModelMapper mapper = new ModelMapper();

	@Override
	public EmployeeDto addEmployee(EmployeeDto employeeDto) throws ServiceException {
		Employee employee = mapper.map(employeeDto, Employee.class);
		Department department = null;
		try {
			
			
			department = employee.getDepartment();
			
			//handling unchecked exception with if else
			
			if(department == null) {
				
				System.err.println("department is null");
			
			}
			else {
			
				employee = er.save(employee);
			
			}
			
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return mapper.map(employee, EmployeeDto.class);
	}

	@Override
	public List<EmployeeDto> getEmployeesByDepartmentId(int dId) throws ServiceException {
		List<Employee> employees = null;
		try {
			
			employees = er.getEmployeeBydId(dId);
			
		} catch (DataAccessException e) {
			throw new ServiceException(e.getMessage());
		}
		return employees.stream().map(employee->mapper.map(employee, EmployeeDto.class)).collect(Collectors.toList());
	}
	
	
	

}
