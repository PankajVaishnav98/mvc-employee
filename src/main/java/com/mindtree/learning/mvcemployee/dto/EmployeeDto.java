package com.mindtree.learning.mvcemployee.dto;



import lombok.Data;


@Data
public class EmployeeDto {

	private int eId;
	
	private String name;
	private int age;
	private String city;
	

	private DepartmentDto department;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(String name, int age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public EmployeeDto(String name, int age, String city, DepartmentDto department) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
		this.department = department;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public DepartmentDto getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentDto department) {
		this.department = department;
	}
	
	
}

