import java.util.Iterator;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Node;

public class SAAJ_Message_Client
{

    public static void main (String args[])
    {
        String operation = "calculateSalary";    // could also be "subtract"
        String urn = "http://data.org/";
        String destination ="http://localhost:8090/CXF-Service/services/EmployeePort";

        try
        {
            // First create the connection
            SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection connection = soapConnFactory.createConnection();

            // Next, create the actual message
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage message = messageFactory.createMessage();

            SOAPPart soapPart = message.getSOAPPart();
            SOAPEnvelope envelope = soapPart.getEnvelope();

            // This method demonstrates how to set HTTP and SOAP headers.
            // setOptionalHeaders(message, envelope);

            // Create and populate the body with Saaj DOM API
            SOAPBody body = envelope.getBody();

            // Create the main element and namespace
            SOAPElement opName = body.addChildElement(
            		 envelope.createName(operation, "ns1", urn));
            // Add parameters
            opName.addChildElement("arg0").addTextNode("Baba Jadhav");
            

            // Save the message
            message.saveChanges();

            //Display the input
             
            System.out.println("\nSoapRequestMessage:\n");
            message.writeTo(System.out);
            System.out.println();
             

            // Send the message and get the reply
            SOAPMessage reply = connection.call(message, destination);
            System.out.println("\nThe SoapResponse object is  "+reply);

            System.out.println("\nSoapResponse Recd :\n");
            reply.writeTo(System.out);
            System.out.println();
             
            
           

            // Retrieve the result values
            soapPart = reply.getSOAPPart();
            envelope = soapPart.getEnvelope();
            body = envelope.getBody();

            Iterator iter = body.getChildElements();
            Node resultOuter = ((Node) iter.next()).getFirstChild();
            Node result = resultOuter.getFirstChild();

            System.out.println("Calculate Salary retunrned the value  "+result.getNodeValue());

            // Check the formatted output
            
            /*System.out.println("\nResponse:\n");
            // Create the transformer
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Extract the content of the reply
            Source sourceContent = reply.getSOAPPart().getContent();
            // Set the output for the transformation
            StreamResult resultOut = new StreamResult(System.out);
            transformer.transform(sourceContent, resultOut);
            System.out.println();
             */
             

            // Close the connection           
            connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // This method demonstrates setting HTTP headers (for authentication)
    // and SOAP headers. Both of these are optional.

    // Note: There's currently a bug in Axis2 (https://issues.apache.org/jira/browse/AXIS2-1014)
    // that prevents SOAP/MIME headers from being transmitted for SAAJ clients.

    private void setOptionalHeaders (SOAPMessage message, SOAPEnvelope envelope) throws SOAPException
    {
        // start: setting HTTP headers - optional, comment out if not needed
            String username = "tomcat";
            String password = "admin";
            
            String authorization = username+":"+password;

           // String authorization = new sun.misc.BASE64Encoder().encode((username+":"+password).getBytes());
            MimeHeaders hd = message.getMimeHeaders();
            hd.addHeader("Authorization", "Basic " + authorization);
        // end: setting HTTP headers

        // start: setting SOAP headers - optional, comment out if not needed
            // Create and populate the header
            SOAPHeader header = message.getSOAPHeader();
            if (header == null)
                header = envelope.addHeader();

            // Will use the default actor "next" for this example,
            // otherwise use he.setActor(String actorURI) to define actor.
            SOAPHeaderElement he = header.addHeaderElement(
                    envelope.createName("foo", "ns1", "http://localhost/SOAPHeader"));
            he.setMustUnderstand(false);
            he.setValue("bar");
        // end: setting SOAP headers
    }
}
