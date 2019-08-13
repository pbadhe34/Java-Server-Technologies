package com.bank.server;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class Client {

	public static void main(String[] args) throws ServiceException, RemoteException, MalformedURLException {
		AccountServiceLocator locator = new AccountServiceLocator();
		
		URL url = new URL("http://localhost:9090/FirstService/services/Account");
		Account account = locator.getAccount(url);
		//Account account = locator.getAccount();
		System.out.println("The account on client is "+account);
		String name = account.getAccountName(1234);
		System.out.println("The account name received is "+name);
		int balance = account.readAccountBalance(name);
		System.out.println("The account balance received is "+balance);
		

	}

}
