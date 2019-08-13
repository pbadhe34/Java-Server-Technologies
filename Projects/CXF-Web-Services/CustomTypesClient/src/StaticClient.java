import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.server.BankService;
import com.server.BankServiceService;
import com.server.BankServiceServiceLocator;
import com.server.User;

 


public class StaticClient {

	/**
	 * @param args
	 * @throws ServiceException 
	 * @throws RemoteException 
	 * @throws MalformedURLException 
	 */
	public static void main(String[] args) throws ServiceException, RemoteException, MalformedURLException {
		// TODO Auto-generated method stub
		BankServiceService service = new BankServiceServiceLocator();
		
		URL url = new URL("http://localhost:8090/CustomTypes/services/BankService");
		
		BankService bs = service.getBankService(url);
		
	 	 
		User obj = bs.getUser(11);
		
		 
		
		System.out.println("The User address is  "+obj.getAddr().getRoad());
		System.out.println("The User balance is  "+obj.getBalance());
		
		
		
		

	}

}
