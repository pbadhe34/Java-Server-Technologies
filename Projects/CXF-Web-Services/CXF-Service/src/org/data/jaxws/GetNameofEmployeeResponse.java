
package org.data.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.2
 * Tue Jul 30 15:29:28 IST 2019
 * Generated source version: 3.3.2
 */

@XmlRootElement(name = "getNameofEmployeeResponse", namespace = "http://data.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNameofEmployeeResponse", namespace = "http://data.org/")

public class GetNameofEmployeeResponse {

    @XmlElement(name = "return")
    private java.lang.String _return;

    public java.lang.String getReturn() {
        return this._return;
    }

    public void setReturn(java.lang.String new_return)  {
        this._return = new_return;
    }

}
