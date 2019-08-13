import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import com.org.sum.AddNumbers;
import com.org.sum.AddNumbersClassService;

import com.handlers.SmallNumberHandler;

public final class Client {

	static QName serviceName = new QName("http://sum.org.com/",	"AddNumbersClassService");

	static QName portName = new QName("http://sum.org.com/","AddNumbersClassPort");

	private Client() {
	}

	public static void main(String[] args) throws Exception {

		URL wsdl = AddNumbersClassService.WSDL_LOCATION;

		AddNumbersClassService service = new AddNumbersClassService(wsdl,
				serviceName);
		AddNumbers port = (AddNumbers) service.getAddNumbersClassPort();

		// Add client side handlers programmatically
		SmallNumberHandler sh = new SmallNumberHandler();
		List<Handler> newHandlerChain = new ArrayList<Handler>();
		newHandlerChain.add(sh);
		((BindingProvider) port).getBinding().setHandlerChain(newHandlerChain);

		int number1 = 10;
		int number2 = 20;

		System.out.printf("Invoking addNumbers(%d, %d)\n", number1, number2);
		int result = port.getSum(number1, number2);
		System.out.printf("The result of adding %d and %d is %d.\n\n", number1,
				number2, result);

		number1 = 3;
		number2 = 5;

		/*System.out.printf("Invoking addNumbers(%d, %d)\n", number1, number2);
		result = port.getSum(number1, number2);
		System.out.printf("The result of adding %d and %d is %d.\n\n", number1,
				number2, result);

		number1 = -10;
		System.out.printf("Invoking addNumbers(%d, %d)\n", number1, number2);
		result = port.getSum(number1, number2);
		System.out.printf("The result of adding %d and %d is %d.\n", number1,
				number2, result);*/

		System.exit(0);
	}
}
