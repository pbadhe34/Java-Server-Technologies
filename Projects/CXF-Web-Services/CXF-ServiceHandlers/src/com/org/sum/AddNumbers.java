package com.org.sum;

import javax.jws.WebService;

@WebService(name = "AddNumbers", targetNamespace = "http://sum.org.com/")
public interface AddNumbers {

	public int getSum(int number1, int number2);

}