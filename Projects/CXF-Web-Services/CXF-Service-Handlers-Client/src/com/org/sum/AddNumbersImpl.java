
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package com.org.sum;

import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.6.8
 * 2013-06-22T03:35:46.887+05:30
 * Generated source version: 2.6.8
 * 
 */

@javax.jws.WebService(
                      serviceName = "AddNumbersClassService",
                      portName = "AddNumbersClassPort",
                      targetNamespace = "http://sum.org.com/",
                      wsdlLocation = "http://localhost:8080/Cxf_Handlers/services/AddNumbersClassPort?wsdl",
                      endpointInterface = "com.org.sum.AddNumbers")
                      
public class AddNumbersImpl implements AddNumbers {

    private static final Logger LOG = Logger.getLogger(AddNumbersImpl.class.getName());

    /* (non-Javadoc)
     * @see com.org.sum.AddNumbers#getSum(int  arg0 ,)int  arg1 )*
     */
    public int getSum(int arg0,int arg1) { 
        LOG.info("Executing operation getSum");
        System.out.println(arg0);
        System.out.println(arg1);
        try {
            int _return = 1419904225;
            return _return;
        } catch (java.lang.Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
