package com.mindtree.learning.mvcemployee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.learning.mvcemployee.model.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

	@Query(value = "select d.name from Department d")
	public List<String> getAllDepartmentNames();
	
	@Query(value = "select d from Department d where d.name = ?1")
	public Department findDepartmentByName(String dName);
	
}
