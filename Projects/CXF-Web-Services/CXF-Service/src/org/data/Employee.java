package org.data;

import javax.jws.WebService;

@WebService(targetNamespace = "http://data.org/", endpointInterface = "org.data.Human", portName = "EmployeePort", serviceName = "EmployeeService")
public class Employee implements Human {
   
	public String getNameofEmployee(int id)
	{
		System.out.println("Employee getNameofEmployee for "+id);
		String name = "Emp "+id;
		return name;
	}
	
	public double calculateSalary(String name)
	{
		System.out.println("Employee calculateSalary for "+name);
		double income = name.length() * 1000;
		return income;
	}
	public void updateEmployee(int empId)
	{
		System.out.println("Employee updateEmployee for "+empId);
		
	}
}
