package com.server;


public class BankService  implements Bank{
	 public User getUser(int id1){
		 System.out.println("Inside BankService getUser ");
		 User obj = new User();
		 obj.setId(id1);
		 obj.setName("DefaultName");
		 obj.setBalance(1265.76);
		 Address location = new Address();
		 obj.setAddr(location);
		 location.setNumber(1367);
		 location.road = "Market Road";
		 return obj;
	 }
	  public boolean updateUser(User obj){
		  System.out.println("Inside BankService updateUser ");
		  System.out.println("User Name recd "+obj.getName());
		  System.out.println("User Id recd "+obj.getId());
		  System.out.println("User Balance recd "+obj.getBalance());
		  System.out.println("User Address location is "+obj.getAddr().road);
		  return true;		  
		  
	  }
}
