package com.mindtree.learning.mvcemployee.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eId;
	
	private String name;
	private int age;
	private String city;
	
	@ManyToOne
	@JsonBackReference
	private Department department;

	public Employee() {
		super();
	}

	public Employee(String name, int age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public Employee(String name, int age, String city, Department department) {
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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}

