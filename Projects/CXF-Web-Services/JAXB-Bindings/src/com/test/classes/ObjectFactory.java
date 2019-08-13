 

package com.test.classes;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
 
 

/**
 *  
 * The  ObjectFactory allows  to programatically 
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

    
     
    public ObjectFactory() {
    }

   
    public Address createIAddress() {
        return new Address();
    }

     
    public Employee createEmployee() {
        return new Employee();
    }

     
    public Location createLocation() {
        return new Location();
    }

     

     

}
