
package com.server.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 2.6.8
 * Sat Sep 07 16:42:41 IST 2013
 * Generated source version: 2.6.8
 */

@XmlRootElement(name = "getAccountBalanceResponse", namespace = "http://server.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAccountBalanceResponse", namespace = "http://server.com/")

public class GetAccountBalanceResponse {

    @XmlElement(name = "return")
    private double _return;

    public double getReturn() {
        return this._return;
    }

    public void setReturn(double new_return)  {
        this._return = new_return;
    }

}
