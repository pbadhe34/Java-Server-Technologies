package com.server;

 
import java.util.Collection;
import java.util.HashMap;

import javax.jws.WebService;
import javax.wsdl.Fault;
import javax.xml.namespace.QName;

import org.apache.cxf.binding.soap.SoapFault;
 

@WebService(targetNamespace = "http://server.com/", portName = "EmployeeInfoPort", serviceName = "EmployeeInfoService")
public class EmployeeInfo 
{
    static HashMap map = new HashMap();
    static {
        Employee emp = new Employee();
        emp.setEmployeeID("#001");
        emp.setEmployeeName("Bill Gates");
		map.put(emp.getEmployeeID(), emp);

		Employee emp2 = new Employee();
        emp2.setEmployeeID("#003");
        emp2.setEmployeeName("John");
        map.put(emp2.getEmployeeID(), emp2);

		Employee emp3 = new Employee();
        emp3.setEmployeeID("#006");
        emp3.setEmployeeName("Ashoka");
        map.put(emp3.getEmployeeID(), emp3);
    }

    public void addEmployee(Employee in) {
    	System.out.println("EmployeeInfo.addEmployee()");
        map.put(in.getEmployeeID(), in);
    }

    public Employee getEmployee(java.lang.String id) throws NoSuchEmployeeFault {
    	System.out.println("EmployeeInfo.getEmployee()");
        Employee emp = (Employee) map.get(id);
        if (emp == null) {
        	System.out.println("Throwing fault error");
        	
        	String message = "The Employee Not Found!";
            String detail = "Employyee id : " + id;  
            
            QName faultCode = new QName("http://server.org.com/","servererror");
            
            SoapFault fault = new SoapFault(message, faultCode);
            throw fault;
            
            
                	 
            /*NoSuchEmployeeFault fault = new NoSuchEmployeeFault();
            fault.setInfo("Could not find employee:" + id);
            throw fault;*/
        }
        return emp;
    }

    public Employee[] getEmployees() {
        Collection values = map.values();
        Employee[] emps = new Employee[values.size()];
        values.toArray(emps);
        return emps;
    }
}
