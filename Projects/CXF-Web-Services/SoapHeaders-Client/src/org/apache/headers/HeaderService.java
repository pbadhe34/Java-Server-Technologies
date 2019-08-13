package org.apache.headers;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.3.2
 * 2019-08-01T14:56:21.410+05:30
 * Generated source version: 3.3.2
 *
 */
@WebServiceClient(name = "HeaderService",
                  wsdlLocation = "http://localhost:9090/CXF-Header-Service/services/SoapPort?wsdl",
                  targetNamespace = "http://apache.org/headers")
public class HeaderService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://apache.org/headers", "HeaderService");
    public final static QName SoapPort = new QName("http://apache.org/headers", "SoapPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:1090/CXF-Header-Service/services/SoapPort?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(HeaderService.class.getName())
                .log(java.util.logging.Level.INFO,
                     "Can not initialize the default wsdl from {0}", "http://localhost:9090/CXF-Header-Service/services/SoapPort?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public HeaderService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public HeaderService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public HeaderService() {
        super(WSDL_LOCATION, SERVICE);
    }

    public HeaderService(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public HeaderService(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public HeaderService(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }




    /**
     *
     * @return
     *     returns HeaderTester
     */
    @WebEndpoint(name = "SoapPort")
    public HeaderTester getSoapPort() {
        return super.getPort(SoapPort, HeaderTester.class);
    }

    /**
     *
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns HeaderTester
     */
    @WebEndpoint(name = "SoapPort")
    public HeaderTester getSoapPort(WebServiceFeature... features) {
        return super.getPort(SoapPort, HeaderTester.class, features);
    }

}