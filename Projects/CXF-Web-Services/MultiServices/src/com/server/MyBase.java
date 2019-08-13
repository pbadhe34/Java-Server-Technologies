package com.server;

import javax.jws.WebService;

 


@WebService(targetNamespace = "http://server.com/", portName = "MyBasePort", serviceName = "MyBaseService")
public class MyBase {

	public MyBase()
	{
		System.out.println("Account.Account()");
	}
	
	public double getAccountBalance(int id)
	{
		System.out.println("Account.getAccountBalance() for  "+id);
		return 12000 + id;
	}
}
