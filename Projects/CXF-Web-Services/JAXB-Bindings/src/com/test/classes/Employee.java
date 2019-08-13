package com.test.classes;

 
import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="emp")
public class Employee {
	
 
  String name;
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
public Date getBirth_Date() {
	return birth_Date;
}
public void setBirth_Date(Date birthDate) {
	birth_Date = birthDate;
}
@XmlElement(name="empAddress")	
public Address getAddress() {
	return address;
}
public void setAddress(Address address) {
	this.address = address;
}
int id;
  Date birth_Date;
  Address address;
}
