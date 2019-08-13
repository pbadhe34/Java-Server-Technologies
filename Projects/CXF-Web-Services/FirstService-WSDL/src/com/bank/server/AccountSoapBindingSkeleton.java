/**
 * AccountSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.bank.server;

public class AccountSoapBindingSkeleton implements com.bank.server.Account, org.apache.axis.wsdl.Skeleton {
    private com.bank.server.Account impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }

    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://server.bank.com", "name"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("readAccountBalance", _params, new javax.xml.namespace.QName("http://server.bank.com", "readAccountBalanceReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://server.bank.com", "readAccountBalance"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("readAccountBalance") == null) {
            _myOperations.put("readAccountBalance", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("readAccountBalance")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://server.bank.com", "acNo"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getAccountName", _params, new javax.xml.namespace.QName("http://server.bank.com", "getAccountNameReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://server.bank.com", "getAccountName"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getAccountName") == null) {
            _myOperations.put("getAccountName", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getAccountName")).add(_oper);
    }

    public AccountSoapBindingSkeleton() {
        this.impl = new com.bank.server.AccountSoapBindingImpl();
    }

    public AccountSoapBindingSkeleton(com.bank.server.Account impl) {
        this.impl = impl;
    }
    public int readAccountBalance(java.lang.String name) throws java.rmi.RemoteException
    {
        int ret = impl.readAccountBalance(name);
        return ret;
    }

    public java.lang.String getAccountName(int acNo) throws java.rmi.RemoteException
    {
        java.lang.String ret = impl.getAccountName(acNo);
        return ret;
    }

}
