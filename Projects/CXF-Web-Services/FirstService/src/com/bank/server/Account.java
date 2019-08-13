package com.bank.server;

public class Account {
	
	 public int readAccountBalance(String name)
	 {
		 System.out.println("The Account readAccountBalance for "+name);
		 int bal = name.length() + 1000;
		 return bal;
	 }
	 
	 public String getAccountName(int acNo)
	 {
		 System.out.println("The Account getAccountName for "+acNo);
		 String name = "UserAccount "+acNo;
		 return name;
	 }
	 private void logAction(String action)
	 {
		 System.out.println("The Account action is  for "+action);
	 }
}


