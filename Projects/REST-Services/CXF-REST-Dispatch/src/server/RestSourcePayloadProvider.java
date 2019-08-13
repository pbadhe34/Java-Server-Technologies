package server;

 

import java.io.InputStream;

import javax.annotation.Resource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.ws.Provider;
import javax.xml.ws.Service;
import javax.xml.ws.ServiceMode;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.WebServiceProvider;
import javax.xml.ws.handler.MessageContext;

import org.w3c.dom.Document;

import org.apache.cxf.message.Message;

@WebServiceProvider()
@ServiceMode(value = Service.Mode.PAYLOAD)
public class RestSourcePayloadProvider implements Provider<DOMSource> {

    @Resource
    protected WebServiceContext wsContext;

    public RestSourcePayloadProvider() {
    }

    public DOMSource invoke(DOMSource request) {
        MessageContext mc = wsContext.getMessageContext();
        String path = (String)mc.get(Message.PATH_INFO);
        String query = (String)mc.get(Message.QUERY_STRING);
        String httpMethod = (String)mc.get(Message.HTTP_REQUEST_METHOD);

        System.out.println("--path--- " + path);
        System.out.println("--query--- " + query);
        System.out.println("--httpMethod--- " + httpMethod);

        if (httpMethod.equalsIgnoreCase("POST")) {
            // TBD: parse query info from DOMSource
            System.out.println("---Invoking updateCustomer---");
            return updateCustomer(request);
        } else if (httpMethod.equalsIgnoreCase("GET")) {
            if (path.equals("/customerservice/customer") && query == null) {
                System.out.println("---Invoking getAllCustomers---");
                return getAllCustomers();
            } else if (path.equals("/customerservice/customer") && query != null) {
                System.out.println("---Invoking getCustomer---");
                return getCustomer(query);
            }
        }

        return null;
    }

    private DOMSource getAllCustomers() {
        return createDOMSource("/CustomerAllResp.xml");
    }

    private DOMSource getCustomer(String customerID) {
        return createDOMSource("/Customer1Resp.xml");
    }

    private DOMSource updateCustomer(DOMSource request) {
        // TBD: returned update customer info
        return createDOMSource("/Customer1Resp.xml");
    }

    private DOMSource createDOMSource(String fileName) {
        DocumentBuilderFactory factory;
        DocumentBuilder builder;
        Document document = null;
        DOMSource response = null;

        try {
            factory = DocumentBuilderFactory.newInstance();
            //factory.setValidating(true);
            builder = factory.newDocumentBuilder();
            InputStream greetMeResponse = getClass().getResourceAsStream(fileName);

            document = builder.parse(greetMeResponse);
            response = new DOMSource(document);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return response;
    }
}
