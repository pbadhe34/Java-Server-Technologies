 

package com.handlers;

import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.transform.Source;
import javax.xml.ws.LogicalMessage;
import javax.xml.ws.ProtocolException;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.handler.LogicalHandler;
import javax.xml.ws.handler.LogicalMessageContext;
import javax.xml.ws.handler.MessageContext;
 

import com.org.sum.GetSum;
import com.org.sum.GetSumResponse;
import com.org.sum.ObjectFactory;
 


/**
 * handles addition of small numbers.
 */
public class SmallNumberHandler implements LogicalHandler<LogicalMessageContext> {


    // Implementation of javax.xml.ws.handler.Handler

    public final boolean handleMessage(LogicalMessageContext messageContext) {
        System.out.println("LogicalMessageHandler handleMessage called");

        try {
            boolean outbound = (Boolean)messageContext.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

            if (outbound) {
                // get the LogicalMessage from our context
                //
                LogicalMessage msg = messageContext.getMessage();

                // check the payload, if its an AddNumbers request, we'll intervene
                //
                JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
                Object payload = msg.getPayload(jaxbContext);
                if (payload instanceof JAXBElement) {
                    payload = ((JAXBElement)payload).getValue();
                }

                if (payload instanceof GetSum) {
                	GetSum req = (GetSum)payload;

                    // now, if the arguments are small, let's do the calculation here
                    //
                    int a = req.getArg0();
                    int b = req.getArg1();

                    if (isSmall(a) && isSmall(b)) {
                        int answer = a + b;
                        
                        
                        GetSumResponse resp = new GetSumResponse();
                        resp.setReturn(answer);
                        msg.setPayload(new ObjectFactory().createGetSumResponse(), jaxbContext);
                        
                        Source src = msg.getPayload();                                             
                        msg.setPayload(src);
                        
                        payload = msg.getPayload(jaxbContext);
                        if (payload instanceof JAXBElement) {
                            payload = ((JAXBElement)payload).getValue();
                        }
                        
                        GetSumResponse resp2 = (GetSumResponse)payload;
                        if (resp2 == resp) {
                            throw new WebServiceException("Shouldn't be the same object");
                        }

                        // indicating that request processing stops here and our answer will be
                        // returned to the client
                        return false;
                    }
                }
            }
            return true;
        } catch (JAXBException ex) {
            throw new ProtocolException(ex);
        }

    }

    public final boolean handleFault(LogicalMessageContext messageContext) {
        System.out.println("LogicalMessageHandler handleFault called");
        System.out.println(messageContext);

        return true;
    }

    public void close(MessageContext ctx) {
        System.out.println("LogicalHandler close called");
    }

    public void init(Map config) {
        System.out.println("LogicalHandler init called");
    }

    public void destroy() {
        System.out.println("LogicalHandler close called");
    }

    private boolean isSmall(int i) {
        return i > 0 && i <= 10;
    }
}
