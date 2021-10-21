package com.mindtree.learning.mvcemployee.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int dId;
	
	@Column(unique = true)
	private String name;
	
	@OneToMany(mappedBy = "department")
	@JsonManagedReference
	private List<Employee> employees;

	public Department() {
		super();
	}

	public Department(String name) {
		super();
		this.name = name;
	}

	public Department(String name, List<Employee> employees) {
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
	
}
