
package org.apache.cxf;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.apache.cxf package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AttachDataHandler_QNAME = new QName("http://cxf.apache.org/", "attachDataHandler");
    private final static QName _AttachByteArray_QNAME = new QName("http://cxf.apache.org/", "attachByteArray");
    private final static QName _AttachByteArrayResponse_QNAME = new QName("http://cxf.apache.org/", "attachByteArrayResponse");
    private final static QName _AttachDataHandlerResponse_QNAME = new QName("http://cxf.apache.org/", "attachDataHandlerResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.apache.cxf
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AttachByteArrayResponse }
     * 
     */
    public AttachByteArrayResponse createAttachByteArrayResponse() {
        return new AttachByteArrayResponse();
    }

    /**
     * Create an instance of {@link AttachDataHandlerResponse }
     * 
     */
    public AttachDataHandlerResponse createAttachDataHandlerResponse() {
        return new AttachDataHandlerResponse();
    }

    /**
     * Create an instance of {@link AttachDataHandler }
     * 
     */
    public AttachDataHandler createAttachDataHandler() {
        return new AttachDataHandler();
    }

    /**
     * Create an instance of {@link AttachByteArray }
     * 
     */
    public AttachByteArray createAttachByteArray() {
        return new AttachByteArray();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachDataHandler }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.apache.org/", name = "attachDataHandler")
    public JAXBElement<AttachDataHandler> createAttachDataHandler(AttachDataHandler value) {
        return new JAXBElement<AttachDataHandler>(_AttachDataHandler_QNAME, AttachDataHandler.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachByteArray }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.apache.org/", name = "attachByteArray")
    public JAXBElement<AttachByteArray> createAttachByteArray(AttachByteArray value) {
        return new JAXBElement<AttachByteArray>(_AttachByteArray_QNAME, AttachByteArray.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachByteArrayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.apache.org/", name = "attachByteArrayResponse")
    public JAXBElement<AttachByteArrayResponse> createAttachByteArrayResponse(AttachByteArrayResponse value) {
        return new JAXBElement<AttachByteArrayResponse>(_AttachByteArrayResponse_QNAME, AttachByteArrayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AttachDataHandlerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cxf.apache.org/", name = "attachDataHandlerResponse")
    public JAXBElement<AttachDataHandlerResponse> createAttachDataHandlerResponse(AttachDataHandlerResponse value) {
        return new JAXBElement<AttachDataHandlerResponse>(_AttachDataHandlerResponse_QNAME, AttachDataHandlerResponse.class, null, value);
    }

}
