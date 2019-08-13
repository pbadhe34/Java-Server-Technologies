import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

//This program looks into the url and dynamically invokes the speciffied opeartions
//No need for proxy interface  or Stub classes on client side 

public class DynamicClient {

	 
	public static void main(String[] args) throws RemoteException, ServiceException, MalformedURLException {
		   String endpoint = "http://localhost:8090/FirstService/services/Account";
		   
		   String method = "getAccountName";
		   Service  service = new Service();
		   Call     call    = (Call) service.createCall();		   

		   call.setTargetEndpointAddress(new java.net.URL(endpoint) );
		   call.setOperationName(method);
		   call.addParameter( "acNo", XMLType.XSD_INT, ParameterMode.IN );		   
		   call.setReturnType( XMLType.XSD_STRING );	   
		    
          //Default return type ?
		   //Above call paarms should be specified if you want to get 
		   //other than string as return type
		  Object result =   call.invoke( new Object [] {7689});//number as param
		   
		  System.out.println("Received  result in Dy call client for name  : " + result); 
		  
		   call.clearOperation();
		   
		   call.setOperationName("readAccountBalance");
		   call.addParameter( "acNo", XMLType.XSD_STRING, ParameterMode.IN );		   
		   call.setReturnType( XMLType.XSD_INT );	
		   
		   result =   call.invoke( new Object [] {"UserName"});
		   System.out.println("Received  result in Dy call client for balance  : " + result); 
			  
			 
		   
			
		   

	}

}
