import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory; 

import com.server.Address;
import com.server.BankService;
import com.server.User;

 

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

//This program looks into the wsdl and gets the proxy interface implementation to invoke the operation
//No need for stub classes on Client side,Needs the proxy interface on client side 


public class ServiceProxyClient {

	 
	public static void main(String[] args) throws ServiceException, MalformedURLException, RemoteException {
		
		String UrlString = "http://localhost:8090/CustomTypes/services/BankService?wsdl";
        String nameSpaceUri = "http://server.com";
        String serviceName = "BankServiceService";
        String portName = "BankService";

        URL serviceUrl = new URL(UrlString);
        QName serviecQName = new QName(nameSpaceUri, serviceName);
        ServiceFactory serviceFactory = ServiceFactory.newInstance();
        Service proxyService = serviceFactory.createService(serviceUrl,serviecQName);

         
        QName portQName = new QName(nameSpaceUri, portName);
       
        BankService myProxy = (BankService) proxyService.getPort(portQName,BankService.class);
        
         User obj = new User();
		 obj.setId(15);
		 obj.setName("Baba");
		 obj.setBalance(4567);
		 Address location = new Address();
		 obj.setAddr(location);
		 location.setNumber(65432);
		 location.setRoad("Meera Bhyander");

        System.out.println(myProxy.updateUser(obj));
        
         User retObj = myProxy.getUser(11);
		
		 
		
		System.out.println("The User address returned is  "+retObj.getAddr().getRoad());
		System.out.println("The User balance returned is  "+retObj.getBalance());

	}

}
