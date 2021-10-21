package com.mindtree.learning.mvcemployee.dto;


import java.util.List;



import lombok.Data;

@Data
public class DepartmentDto {

	
	private int dId;
	
	private String name;

	private List<EmployeeDto> employees;

	public DepartmentDto() {
		super();
	}

	public DepartmentDto(String name) {
		super();
		this.name = name;
	}

	public DepartmentDto(String name, List<EmployeeDto> employees) {
		super();
		this.name = name;
		this.employees = employees;
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EmployeeDto> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDto> employees) {
		this.employees = employees;
	}
	
	
	
}
