
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

@XmlRootElement(name = "calculateSalaryResponse", namespace = "http://data.org/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculateSalaryResponse", namespace = "http://data.org/")

public class CalculateSalaryResponse {

    @XmlElement(name = "return")
    private double _return;

    public double getReturn() {
        return this._return;
    }

    public void setReturn(double new_return)  {
        this._return = new_return;
    }

}

