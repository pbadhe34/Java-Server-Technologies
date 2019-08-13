import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.ServiceFactory;

import org.apache.axis.client.Service;

import com.bank.server.Account;
 

public class DynamicProxyClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws ServiceException,
			MalformedURLException, RemoteException {

		String UrlString = "http://localhost:8090/FirstService/services/Account?wsdl";
		String nameSpaceUri = "http://server.bank.com";
		String serviceName = "AccountService";
		String portName = "Account";

		URL serviceUrl = new URL(UrlString);
		QName serviecQName = new QName(nameSpaceUri, serviceName);
		ServiceFactory serviceFactory = ServiceFactory.newInstance();
		Service proxyService = (Service) serviceFactory.createService(
				serviceUrl, serviecQName);

		QName portQName = new QName(nameSpaceUri, portName);
		Account myProxy = (Account) proxyService.getPort(portQName,
				com.bank.server.Account.class);
		
		System.out.println("The account on proxy client is "+myProxy);
		String name = myProxy.getAccountName(5678);
		System.out.println("The account name received by proxy client is "+name);
		int balance = myProxy.readAccountBalance(name);
		System.out.println("The account balance received by proxy client is "+balance);
		

		 
	}

}
