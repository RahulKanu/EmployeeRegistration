package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
	
	private Integer id;
	private String firstName;
	private String lastName;
	private String gender;
	private String dateOfBirth;
	private String Department;
	
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", gender=").append(gender).append(", dateOfBirth=").append(dateOfBirth)
				.append(", Department=").append(Department).append("]");
		return builder.toString();
	}
	public Employee(Integer id, String firstName, String lastName, String gender, String dateOfBirth,
			String department) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		Department = department;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
