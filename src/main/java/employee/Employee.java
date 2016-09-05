package main.java.employee;

import java.io.Serializable;

abstract class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private static int idCounter;
	private int id = 0;

	public Employee(String name) {
		this.name = name;
		idCounter++;
		this.id = idCounter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public abstract double MounthSalary();

	public String toString() {
		return "Name: " + name + ", id: " + id + ", salary: " + MounthSalary();
	}
}

class EmployeeFixedRate extends Employee {
	
	private double fixedPayment;

	private static final long serialVersionUID = 1L;

	public EmployeeFixedRate(String name, double fixedPayment) {
		super(name);
		this.fixedPayment = fixedPayment;
	}

	public double MounthSalary() {
		return fixedPayment;
	}
}

class EmployeeHourlyWage extends Employee {
	
	private double hourlyWage;

	private static final long serialVersionUID = 1L;

	public EmployeeHourlyWage(String name, double hourlyWage) {
		super(name);
		this.hourlyWage = hourlyWage;
	}

	public double MounthSalary() {
		return 20.8 * 8 * hourlyWage;
	}
}
