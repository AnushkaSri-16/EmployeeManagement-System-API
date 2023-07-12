package com.prog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
//this code defines an entity class for an employee, which can be used to interact with a database using JPA.


@Entity
//The @Entity annotation marks the class as a JPA entity, which maps to a database table.
@Table(name = "EMP_SYSTEM")
//The @Table annotation specifies the name of the database table that corresponds to this entity.
public class Employee {

	@Id
	//The @Id annotation is used to mark the id field as the primary key of the entity. 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//The @GeneratedValue annotation specifies that the value of the primary key will be
	//automatically generated when a new employee is created.
	private int id;
	private String name;
	private String address;
	private String email;
	private String phno;
	private int salary;

	//The class contains private instance variables with public getter and setter methods, 
	//which provide access to the data fields. The data fields represent the attributes of an employee,
	//such as name, address, email, phone number, and salary.
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		
		//The toString() method is overridden to provide a string representation of the object.
		//This method is often used for debugging purposes and provides a convenient way to
		//print the contents of the object to the console.
		
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", phno=" + phno
				+ ", salary=" + salary + "]";
	}
}