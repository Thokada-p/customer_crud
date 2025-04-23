package com.flm.model;

public class Employee {
private Long id;
private String firstName;
private String lastName;
private Double salary;
private String address;

public Employee(Long id, String fname, String lname, Double salary, String address) {
	super();
	this.id = id;
	this.firstName = fname;
	this.lastName = lname;
	this.salary = salary;
	this.address = address;
}
public Employee(String fname, String lname, Double salary, String address) {
	super();
	
	this.firstName = fname;
	this.lastName = lname;
	this.salary = salary;
	this.address = address;
}
public Employee() {
	super();
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFname() {
	return firstName;
}
public void setFname(String fname) {
	this.firstName = fname;
}
public String getLname() {
	return lastName;
}
public void setLname(String lname) {
	this.lastName = lname;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}
