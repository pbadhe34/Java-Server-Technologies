
package org.data.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * This class was generated by Apache CXF 3.3.2
 * Tue Jul 30 15:29:29 IST 2019
 * Generated source version: 3.3.2
 */

@XmlRootElement(name = "getNameofEmployee", namespace = "http://data.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getNameofEmployee", namespace = "http://data.org/")

public class GetNameofEmployee {

    @XmlElement(name = "arg0")
    private int arg0;

    public int getArg0() {
        return this.arg0;
    }

    public void setArg0(int newArg0)  {
        this.arg0 = newArg0;
    }

}

