import java.io.*;
import javax.xml.ws.*;
import javax.xml.namespace.QName;
import javax.xml.ws.soap.*;
import javax.xml.soap.*;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.Source;
import java.net.*;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;

//Only the Java6 runtime and no interface or cxf jars needed to run

public class DynamicDispatchClient {
	public static void main(String[] args) throws MalformedURLException {

		// Create a Service instance based on the location of the WSDL
		// URL wsdlLocation = new URL
		// ("http://localhost:9090/Cxf_Service/services/AccountPort?wsdl");

		// Service service = Service.create (wsdlLocation, serviceName);

		String endpointAddress = "http://localhost:9090/Cxf_Service/services/AccountPort"; // web
																							// service
																							// url
		QName serviceName = new QName("http://server.org.com/",
				"AccountService");// service name
		// Create a dynamic Service instance
		Service service = Service.create(serviceName);

		// QName for Port As defined in wsdl.
		QName portName = new QName("http://server.org.com/", "AccountPort");

		// Add a port to the Service
		service.addPort(portName, SOAPBinding.SOAP11HTTP_BINDING,
				endpointAddress);

		//Build the xml soap message structure as part of request
		String xmlMessage = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">" +
				"<soap:Body><ns2:processData xmlns:ns2=\"http://server.org.com/\">" +
				"<arg0>24</arg0><arg1>12.678</arg1></ns2:processData></soap:Body>" +
				"</soap:Envelope>";

		SOAPMessage xmlSoapMessage = null;
		try {
			// Create SOAPMessage Dispatch to dispatch request to webs ervice
			// port Name
			Dispatch<SOAPMessage> SmDispatch = service.createDispatch(portName,
					SOAPMessage.class, Service.Mode.MESSAGE);

			MessageFactory factory = MessageFactory.newInstance();

			StringReader reader = new StringReader(xmlMessage);

			StreamSource src = new StreamSource(reader);

			// Create a Soap Request Message
			xmlSoapMessage = factory.createMessage();
			// pass on the string data to message
			xmlSoapMessage.getSOAPPart().setContent((Source) src);
			xmlSoapMessage.saveChanges();

			System.out
					.println("\nInvoking the operation with Soap Request Message : ");
			System.out.println(xmlMessage);

			System.out.println("\n");

			SOAPMessage response = SmDispatch.invoke(xmlSoapMessage);// synchronous
																		// call..wait
																		// for
																		// the
																		// response

			Source xmlResponse = response.getSOAPPart().getContent();

			String xmlString = sourceToXMLString(xmlResponse);// Convert the
																// soap part to
																// xml format

			System.out.println("Received Soap xml response: ");
			System.out.println(xmlString);
			System.out.println("\n");
			// Find the index of "return" string and get the data inbetween

			String srch = "<return>";
			int length = srch.length();
			int index1 = xmlString.lastIndexOf("<return>");
			int index2 = xmlString.lastIndexOf("</return>");
			String data = xmlString.substring(index1 + length, index2);
			System.out.println("Result received " + data);
		} catch (SOAPException e) {
			e.printStackTrace();
		}

	}

	// This is used to convert soap response part to string format
	private static String sourceToXMLString(Source result) {

		String xmlResult = null;
		try {
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION,
					"yes");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			OutputStream out = new ByteArrayOutputStream();
			StreamResult streamResult = new StreamResult();
			streamResult.setOutputStream(out);
			transformer.transform(result, streamResult);
			xmlResult = streamResult.getOutputStream().toString();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return xmlResult;
	}

}
