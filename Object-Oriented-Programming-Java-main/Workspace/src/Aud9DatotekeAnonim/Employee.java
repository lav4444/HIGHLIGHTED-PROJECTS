package Aud9DatotekeAnonim;

import java.time.LocalDate;
import java.util.*;

public class Employee {
	
	List<Employee> listaSvihZap = new LinkedList<>();
	
	@Override
	public String toString() {
		return "[employee = " + employee + ", salary = " + salary + ", startedAt = " + startedAt + "]";
	}

	public Employee(String employee, double salary, LocalDate startedAt) {
		//super();
		this.employee = employee;
		this.salary = salary;
		this.startedAt = startedAt;
		//listaSvihZap.add(new Employee(employee, salary, startedAt));
	}

	public String getEmployee() {
		return employee;
	}

	public void setEmployee(String employee) {
		this.employee = employee;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public LocalDate getStartedAt() {
		return startedAt;
	}

	private String employee;
	private double salary;
	private LocalDate startedAt;
	
	public void raiseSalary(double byPercentage) {
		double kofa = byPercentage/100.0 + 1.0;
		setSalary(getSalary()*kofa);
		System.out.println();
	}

}
