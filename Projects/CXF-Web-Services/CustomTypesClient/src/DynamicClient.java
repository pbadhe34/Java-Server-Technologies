import java.net.MalformedURLException;
import java.rmi.RemoteException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import com.server.Address;
import com.server.User;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;

//This program looks into the url and dynamically invokes the speciffied opeartions
//No need for proxy interface  or Stub classes on client side 

public class DynamicClient {

	 
	public static void main(String[] args) throws RemoteException, ServiceException, MalformedURLException {
		   String endpoint = "http://localhost:8090/CustomTypes/services/BankService";
		   
		   String method = "getUser";
		   Service  service = new Service();
		    
		   Call     call    = (Call) service.createCall();	
		   
		    QName    qclassName      = new QName( "urn:BankService", "User" );

	        call.registerTypeMapping(com.server.User.class, qclassName,
	                      new org.apache.axis.encoding.ser.BeanSerializerFactory(com.server.User.class, qclassName),        
	                      new org.apache.axis.encoding.ser.BeanDeserializerFactory(com.server.User.class, qclassName));        
	    

		   call.setTargetEndpointAddress(new java.net.URL(endpoint) );
		   call.setOperationName(method);
		    
		   call.addParameter( "param1", XMLType.XSD_INT, ParameterMode.IN ); 
		   
		   call.setReturnType(qclassName );
		   
		    
          //Default return type is Object/String
		   //Above call paarmeters should be specified if you want to get 
		   //other than string as return type from this call-invoke
		  User  obj =   (User) call.invoke( new Object [] {new Integer(33)});
		  
		  //Object object =   call.invoke( new Object [] {new Integer(23)});		  
		  //User  obj= (User) object;
		   
		  System.out.println("Received User balance : " + obj.getBalance());
		  System.out.println("Received User address : " + obj.getAddr().getRoad());
		  
		  //Second dynamic call
		   //call.clearHeaders();
		   call.clearOperation();//Clear the acll settings
		  
		   call.setTargetEndpointAddress(new java.net.URL(endpoint) );
		   call.setOperationName("updateUser");
		    
		   call.addParameter( "param1", qclassName, ParameterMode.IN ); //input parameter
		   
		   call.setReturnType(XMLType.XSD_BOOLEAN );
		   
		     User inObj = new User();
		     inObj.setId(45);
		     inObj.setName("Kiadh");
		     inObj.setBalance(1122);
			 Address location = new Address();
			 inObj.setAddr(location);
			 location.setNumber(6725);
			 location.setRoad("Gaonkar-Road");
		   
		      Object res =   call.invoke( new Object [] {inObj});		  
			   
			   
			  System.out.println("Received User Update : " + res);


	}

}
