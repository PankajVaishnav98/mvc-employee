package com.mindtree.learning.mvcemployee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.learning.mvcemployee.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	@Query(value = "Select e from Employee e where e.department.dId = ?1")
	public List<Employee> getEmployeeBydId(int dId);
	
}
