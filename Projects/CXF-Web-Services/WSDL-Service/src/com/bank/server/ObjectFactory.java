
package com.bank.server;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.bank.server package. 
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


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.bank.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReadAccountBalance }
     * 
     */
    public ReadAccountBalance createReadAccountBalance() {
        return new ReadAccountBalance();
    }

    /**
     * Create an instance of {@link ReadAccountBalanceResponse }
     * 
     */
    public ReadAccountBalanceResponse createReadAccountBalanceResponse() {
        return new ReadAccountBalanceResponse();
    }

    /**
     * Create an instance of {@link GetAccountName }
     * 
     */
    public GetAccountName createGetAccountName() {
        return new GetAccountName();
    }

    /**
     * Create an instance of {@link GetAccountNameResponse }
     * 
     */
    public GetAccountNameResponse createGetAccountNameResponse() {
        return new GetAccountNameResponse();
    }

}
