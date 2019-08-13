package org.data;

import javax.jws.WebService;

@WebService(name = "Human", targetNamespace = "http://data.org/")
public interface Human {

	String getNameofEmployee(int id);

	double calculateSalary(String name);

}