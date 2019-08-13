 

package com.org.sum;

import javax.jws.HandlerChain;
import javax.jws.WebService;



 
@WebService(targetNamespace = "http://sum.org.com/", endpointInterface = "com.org.sum.AddNumbers", portName = "AddNumbersClassPort", serviceName = "AddNumbersClassService")
@HandlerChain(file = "/handlers.xml")//specify chain of handlkers
public class AddNumbersClass implements AddNumbers     {


     
    public int getSum(int number1, int number2) {
        System.out.println("getSum called....." + number1 + ":" + number2);
        if (number1 < 0 || number2 < 0) {
            String message = "Negative number cant be added!";
            String detail = "Numbers: " + number1 + ", " + number2;
            return 0; 
        }
        return number1 + number2;
    }

}
