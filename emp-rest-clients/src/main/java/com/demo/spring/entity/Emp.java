package com.demo.spring.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Emp {
	private int empid;
	private String name;
	private String city;
	private double salary;

	public Emp() {
		
	}

	
	public Emp(int empid, String name, String city, double salary) {
		this.empid = empid;
		this.name = name;
		this.city = city;
		this.salary = salary;
	}


	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public String toString() {
		return empid + " " + name + " " + city + " " + salary;
	}

}
